import plotly.graph_objects as go
import sys, getopt, time
import math

# Se inicializa todo en 0
a = 0
b = math.pi / 6
h = 0.01
alpha = math.sqrt(3)
beta =  math.sqrt(3)
N =  ite = 0
tk = 1
max_ite = 100
tol = 0.01
funcion_f = "-4*y"
funcion_e = "math.sqrt(3)*math.cos(2*t)+(math.sqrt(3)/(2*math.sin(math.pi/3)))*math.sin(2*t)"
debug = False
quiet = False
tiros = []


class Tiro():
    def __init__(self, tiro):
        self.tiro = tiro
        self.data = {"time": [], "y": [], "z": [], "exac": [], "error": []}

    def add_t(self,t):
        self.data['time'].append(t)

    def add_y(self,y):
        self.data['y'].append(y)

    def add_z(self,z):
        self.data['z'].append(z)

    def add_e(self,e):
        self.data['exac'].append(e)

    def add_err(self,err):
        self.data['error'].append(err)

# MATEMATICAS
def f(t, y, z):
    if debug:
        print(funcion_f)
    return eval(funcion_f)


def f_e(t, y, z):
    if len(funcion_e) != 0:
        if debug:
            print(funcion_e)
        if funcion_e == "":
            return eval(funcion_f)
        return eval(funcion_e)
    # falta calcularla
    return 1


def metodo(func):
    def met_num(t, y, z):
        titulo = "Metodo de " + str(func.__name__).capitalize()
        title(titulo)
        muestra(0, t, y, z)
        func(t, y, z)
    return met_num

@metodo
def euler(t, y):
    for i in range(1, N + 1):
        y = y + h * f(t, y)
        t += h
        muestra(i, t, y, z)


@metodo
def heun(t, y):
    for i in range(1, N + 1):
        y_int = y + h * f(t, y)
        y = y + ((0.5 * h) * (f(t, y) + f(t + h, y_int)))
        t += h
        muestra(i, t, y, z)


@metodo
def runge_kutta_3(t, y):
    for i in range(1, N + 1):
        k_1 = h * f(t, y)
        l_1 = h * f(t, y)

        k_2 = h * (z + (0.5*k_1))
        l_2 = h * f(t + (0.5 * h), y + (0.5 * k_1), z + (0.5 * l_1) )

        k_3 = h *  (z - l_1 + (2.0 * l_2))
        l_3 = h * f(t + h, y - k_1 + (2.0 * k_2), z - l_1 + (2.0 * l_2))

        y = y + (1.0 / 6.0) * (k_1 + (4.0 * k_2) + k_3)
        z = z + (1.0 / 6.0) * (l_1 + (4.0 * l_2) + l_3)
        t += h
        muestra(i, t, y, z)


@metodo
def runge_kutta_4(t, y, z):
    for i in range(1, N + 1):
        k_1 = h * z
        l_1 = h * f(t, y, z)

        k_2 = h * (z + (0.5*k_1))
        l_2 = h * f(t + (0.5 * h), y + (0.5 * k_1), z + (0.5 * l_1) )

        k_3 = h *  (z + (0.5*k_2))
        l_3 = h * f(t + (0.5 * h), y + (0.5 * k_2), z + (0.5 * l_2) )

        k_4 = h * (z + k_3)
        l_4 = h * f(t + h, y + k_3, z + l_3)

        y = y + (1.0 / 6.0) * (k_1 + (2.0 * k_2) + (2.0 * k_3) + k_4)
        z =  z + (1.0 / 6.0) * (l_1 + (2.0 * l_2) + (2.0 * l_3) + l_4)
        t += h
        muestra(i, t, y, z)

# SALIDA DE DATOS
def muestra(i, t, y, z):
    exac =  f_e(t, y, z)
    error = err(y, f_e(t, y, z))
    save(ite, t, y, z, exac, error)
    error = round(error, 5)
    if quiet:
        # No muestres nada
        return
    elif debug:
        print(f"{i} -\tt: {t}\ty: {y}\texac: {exac}\tErr: {error if (funcion_e != '') else 'n/a'} %")
    else:
        print(
            f"{i} -\tt: {round(t,3)}\ty: {round(y,4)}\texac: {round(exac,4)}"+
            f"\tErr: {error if (funcion_e != '') else 'n/a'} %"
        )


def err(y, y_exac):
    return 100 * (abs(y - y_exac) / abs(y_exac))


def err_total():
    if funcion_e != "":
        error = []
        for tiro in tiros:
            prom_e_tiro = sum(tiro.data["error"])/len(tiro.data['error'])
            error.append(prom_e_tiro)
        return sum(error) / len(error)
    return 0


def muestra_err_total():
    if not funcion_e == "":
        title(
            f"\n {ite} tiros - Error Promedio : {round(err_total(),20)} %\n", 
            "-",
        )


def title(str_title, sep_char="="):
    sep = "\n"
    for i in range(len(str_title) + 2):
        sep += sep_char
    print("\n" + sep + "\n " + str_title + sep)


def save(i, t, y, z, e, err):
    tiros[i].add_t(t)
    tiros[i].add_y(y)
    tiros[i].add_z(z)
    tiros[i].add_e(e)
    tiros[i].add_err(err)
    pass


# GRAPHS
def graph(title, err):
    nth = 255/len(tiros)
    it = 0
    # Create and style traces
    fig = go.Figure()
    for tiro in tiros:
        fig.add_trace(
            go.Scatter(
                x=tiro.data["time"],
                y=tiro.data["y"],
                name=f"tiro:{tiro.tiro}",
                mode=f"{'lines+' if tiros[-1] is tiro else ''}markers",
                line_color=f'rgb(0,{nth*it},{nth*it})'
            )
        )
        it+=1
    fig.add_trace(
        go.Scatter(
            x=tiro.data["time"],
            y=tiros[-1].data["exac"],
            name="Funcion",
            mode="lines+markers",
            line_color='rgb(70,170,50)'
        )
    )
    fig.update_layout(
        annotations=[
            dict(
                xref="paper",
                yref="paper",
                x=0.0,
                y=1.05,
                xanchor="left",
                yanchor="bottom",
                text=title,
                font=dict(family="Fira Code", size=30, color="rgb(37,37,37)"),
                showarrow=False,
            ),
        ]
    )
    fig.show()


def secante():
    global tk
    if ite < 2:
        if tk == 0: 
            tk = 5
        tk *= 2 
    else:
        gt0 = float(tiros[ite-1].data['y'][-1]-beta)
        gt = float(tiros[ite].data['y'][-1]-beta)
        t0 = float(tiros[ite-1].tiro)
        t = float(tk)
        tk = float( t - (((t-t0)/(gt-gt0))*gt))


def main():
    # Set condiciones iniciales
    global a, b, N, h, funcion_f, funcion_e, quiet, debug, tk, ite

    # Parse options
    try:
        opts, args = getopt.getopt(sys.argv[1:], "hqd", ["help", "quiet", "debug"])
        for opt, arg in opts:
            if opt in ("-h", "--help"):
                print("-q --quiet (Quiet mode)\n-d --debug ")
                sys.exit()
            elif opt in ("-d", "--debug"):
                debug = True
            elif opt in ("-q", "--quiet"):
                quiet = True
    except getopt.GetoptError:
        sys.exit(2)

    # Inputs
    # a = int(input("Limite Inicial: "))
    # alpha = int(input("Valor en el Limite Inicial: "))
    # b = int(input("Limite Final: "))
    # betha = int(input("Valor en el Limite Final: "))
    # h = int(input("Tamaño de paso a usar: "))
    # max_ite = int(input("Maximo de iteraciones (tiros): "))
    # tol = int(input("Tolerancia de la solucion: "))

    # Acomoda los limites
    if a > b:
        h = a
        a = b
        b = h
    N = int((b - a) / h)

    # No muestres mas de 100 iteraciones
    if N > 100:
        quiet = True

    # tk primera evaluacion
    tk = (beta - alpha)/(b-a)

    # Set funcion
    # funcion_f = input("La funcion a evaluar:\n> ")

    # Funcion exacta
    # funcion_e = input("Funcion exacta: \n> ")

    ite = 0
    while True:
        title(str(tk))
        tiros.append(Tiro(tk))
        runge_kutta_4(a,alpha,tk)
        yb_t = tiros[ite].data['y'][-1]
        diff = abs(yb_t-beta)
        title(str(diff))
        if diff > tol and ite < max_ite:
            secante()
            ite+=1
            continue
        break

    graph("Metodo numerico", err_total())
    muestra_err_total()

if __name__ == "__main__":
    main()
