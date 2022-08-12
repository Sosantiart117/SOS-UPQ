import plotly.graph_objects as go
import sys, getopt, time
import math

# Se inicializa todo en 0
a = 0
b = math.pi / 6
h = 0
N = 20
ite = 0
tk = 1
max_ite = 100
tol = 0.1
# implementa forma de guardar tiros
tiros = []

# Problema de clase
funcion_f = "-4*y"
alpha = math.sqrt(3)
beta =  math.sqrt(3)
# falta calcularlo
funcion_e = ""



# MATEMATICAS
def f(t, y, z):
    return eval(funcion_f)


def f_e(t, y, z):
    # falta calcularla la solucion exacta
    if len(funcion_e) != 0:
        return eval(funcion_e)
    return 0

def runge_kutta_4(t, y, z):
    title("Iteraciones por RK4")
    muestra(0, t, y, z)
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
    # muestra tu tabla
    pass


def save(i, t, y, z, e, err):
    # guarda datos
    pass


# GRAPHS
def graph(title, err):
    # Create and style traces
    fig = go.Figure()
    for tiro in tiros:
        fig.add_trace(
            go.Scatter(
                x=tiro.data["time"],
                y=tiro.data["y"],
                mode="lines",
                line_color='rgb(150,102,32)'
            )
        )
        it+=1
    if len(funcion_e) != 0:
        fig.add_trace(
            go.Scatter(
                x=tiro.data["time"],
                y=tiros[-1].data["exac"],
                name="F exacta",
                mode="lines",
                line_color='rgba(30,150,240,100)'
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
        else:
            tk *= 2 
    else:
        gt0 = float(tiros[ite-1].data['y'][-1]-beta)
        gt = float(tiros[ite].data['y'][-1]-beta)
        t0 = float(tiros[ite-1].tiro)
        t = float(tk)
        tk = float( t - (((t-t0)/(gt-gt0))*gt))

def nuevo_tiro(diff):
    global tk
    if diff > tol:
        tk /= 2
    else:
        tk *= 2
    if ite < 2:
        return
    yb1 = penultimo_yb
    yb2 = ultimo_yb
    d1 = penultimo_tiro
    d2 = ultimo_tiro
    tk = ((diff-yb2)/(yb1-yb2))*d1 + ((diff-yb1)/(yb2-yb1))*d2





def main():
    # Set condiciones iniciales
    global a, b, N, h, funcion_f, funcion_e, tk, ite

    # Toma Inputs

    # Acomoda los limites

    # tk primera evaluacion
    tk = (beta - alpha)/(b-a)

    ite = 0
    while True:
        # Guarda los tiros
        runge_kutta_4(a,alpha,tk)
        # Toma el ultimo tiro
        # ultimo_tiro = pass
        # diff = abs(ultimo_tiro-beta)
        if diff > tol and ite < max_ite:
            nuevo_tiro(diff)
            ite+=1
            continue
        break

    graph(f"Metodo disparo para: {funcion_f}", err_final())
    muestra_err_final()

if __name__ == "__main__":
    main()
