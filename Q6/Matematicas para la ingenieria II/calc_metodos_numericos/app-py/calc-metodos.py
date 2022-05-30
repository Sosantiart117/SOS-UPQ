import plotly.graph_objects as go
import sys, getopt, time
import math

# Se inicializa todo en 0
a = b = N = h = t_0 = y_0 = 0
funcion_e = funcion_f = ""
debug = False
quiet = False
data = {"time": [], "y": [], "exac": [], "error": []}


def main():
    # Set condiciones iniciales
    global a, b, N, y_0, t_0, h, funcion_f, funcion_e, quiet, debug

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
    a = int(input("Dame el limite inicial: "))
    b = int(input("Dame el limite final: "))
    N = int(input("Cuantos pasos quiere usar: "))

    # No muestres mas de 100 iteraciones
    if N > 99:
        quiet = True

    # Valores iniciales
    val = input("Tiene Valores iniciales [s/N]: ")
    if val in ("s", "S"):
        y_0 = int(input("El valor de y: "))
        t_0 = int(input("El valor de t: "))

    # Acomoda los limites
    if a > b:
        h = a
        a = b
        b = x
    h = (b - a) / N

    # Set funcion
    funcion_f = input("La funcion a evaluar:\n> ")
    # Funcion exacta
    val = input("Tiene solucion exacta [s/N]: ")
    if val in ("s", "S"):
        funcion_e = input("Funcion exacta: \n> ")
        print(funcion_e)

    # Selector de metodos
    while True:
        if quiet:
            input_str = ">"
        else:
            print(
                """
    Siguientes metodos dispobiles:
    1: Euler
    2: Heun
    3: Runge-Kutta 3
    4: Runge-Kutta 4

    0: Finalizar
"""
            )
            input_str = "Seleccion\t: "
        metodo = int(input(input_str))
        if metodo < 1:
            print("\n\nFin de la ejecucion")
            break
        elif metodo > 4:
            print("No se ha implementado")
            continue
        elif metodo == 1:
            euler(t_0, y_0)
        elif metodo == 2:
            heun(t_0, y_0)
        elif metodo == 3:
            runge_kutta_3(t_0, y_0)
        elif metodo == 4:
            runge_kutta_4(t_0, y_0)


# MATEMATICAS

def f(t, y):
    if debug:
        print(funcion_f)
    return eval(funcion_f)


def f_e(t, y):
    if debug:
        print(funcion_e)
    if funcion_e == "":
        return eval(funcion_f)
    return eval(funcion_e)


def metodo(func):
    def met_num(t, y):
        titulo = "Metodo de " + str(func.__name__).capitalize()
        title(titulo)
        muestra(0, t, y)
        func(t, y)
        graph(titulo,err_total())
        muestra_err_total()

    return met_num


@metodo
def euler(t, y):
    for i in range(1, N + 1):
        y = y + h * f(t, y)
        t += h
        muestra(i, t, y)


@metodo
def heun(t, y):
    for i in range(1, N + 1):
        y_int = y + h * f(t, y)
        y = y + ((0.5 * h) * (f(t, y) + f(t + h, y_int)))
        t += h
        muestra(i, t, y)


@metodo
def runge_kutta_3(t, y):
    for i in range(1, N + 1):
        k_1 = h * f(t, y)
        k_2 = h * f(t + (0.5 * h), y + (0.5 * k_1))
        k_3 = h * f(t + h, y - k_1 + (2.0 * k_2))
        y = y + (1.0 / 6.0) * (k_1 + (4.0 * k_2) + k_3)
        t += h
        muestra(i, t, y)


@metodo
def runge_kutta_4(t, y):
    for i in range(1, N + 1):
        k_1 = h * f(t, y)
        k_2 = h * f(t + (0.5 * h), y + (0.5 * k_1))
        k_3 = h * f(t + (0.5 * h), y + (0.5 * k_2))
        k_4 = h * f(t + h, y + k_3)
        y = y + (1.0 / 6.0) * (k_1 + (2.0 * k_2) + (2.0 * k_3) + k_4)
        t += h
        muestra(i, t, y)


# SALIDA DE DATOS


def muestra(i, t, y):
    error = err(y, f_e(t, y))
    save(t, y, error)
    error = round(error, 5)
    if quiet:
        # No muestres nada
        return
    elif debug:
        print(f"{i} -\tt: {t}\ty: {y}\tErr: {error if (funcion_e != '') else ''} %")
    else:
        print(
            f"{i} -\tt: {round(t,3)}\ty: {round(y,4)}\tErr: {error if (funcion_e != '') else ''} %"
        )


def err(y, y_exac):
    return 100 * (abs(y - y_exac) / abs(y_exac))

def err_total():
    return sum(data['error'])/len(data['error'])


def muestra_err_total():
    if not funcion_e == "":
        title(
            f"\n {N} ejecuciones - Error Promedio : {round(err_total(),20)} %\n",
            "-",
        )
    # Flush data
    for i in data:
        data[i].clear()


def title(str_title, sep_char="="):
    sep = "\n"
    for i in range(len(str_title) + 2):
        sep += sep_char
    print("\n" + sep + "\n " + str_title + sep)


def save(t, y, error):
    global data
    data["time"].append(t)
    data["y"].append(y)
    data["exac"].append(f_e(t, y))
    data["error"].append(error)


# GRAPHS
def graph(title,err):
    fig = go.Figure()
    # Create and style traces
    fig.add_trace(
        go.Scatter(
            x=data["time"],
            y=data["y"],
            name="Y-Calculada",
            mode="lines+markers",
            line=dict(color="firebrick", width=4),
        )
    )
    if funcion_e != "":
        fig.add_trace(
            go.Scatter(
                x=data["time"],
                y=data["exac"],
                mode="lines",
                name="Y-Exacta",
                line=dict(color="royalblue", width=4),
            )
        )
        fig.add_trace(
            go.Scatter(
                x=data["time"],
                y=data["error"],
                mode="lines",
                name="Error",
                line=dict(color="green", width=4),
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
            ) ,
            dict(
                xref="paper",
                yref="paper",
                x=0.0,
                y=1.05,
                xanchor="left",
                yanchor="top",
                text="Error total: "+str(round(err,20))+"%",
                font=dict(family="Fira Code", size=30, color="rgb(37,37,37)"),
                showarrow=False,
            )
        ]
    )
    fig.show()


if __name__ == "__main__":
    main()
