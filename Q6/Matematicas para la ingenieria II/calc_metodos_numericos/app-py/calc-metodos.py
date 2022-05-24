import math

#Se inicializa todo en 0
a = b = N = h = t_0 = y_0 = 0
funcion_e = funcion_f = ""
err_a = []
debug = False
quiet = False

def main():
    # Set condiciones iniciales
    global a, b, N, y_0, t_0, h, funcion_f, funcion_e, quiet
    a = int(input("Dame el limite inicial: "))
    b = int(input("Dame el limite final: "))
    N = int(input("Cuantos pasos quiere usar: "))

    # No muestres mas de 100 iteraciones
    if N > 99:
        quiet = True

    # Valores iniciales
    val = input("Tiene Valores iniciales [s/N]: ")
    if val == "s" or val == "S":
        y_0 = int(input("El valor de y: "))
        t_0 = int(input("El valor de t: "))

    
    # Acomoda los limites
    if(a>b):
        h = a
        a = b
        b = x
    h = (b-a)/N

    # Set funcion 
    funcion_f = input("Dame la funcion a evaluar:\n> ")
    # Funcion exacta
    val = input("Tiene solucion exacta [s/N]: ")
    if val == "s" or val == "S":
        funcion_e = input("Funcion para evaluar rendimiento: \n> ")

    while True:
        # Escoge un metodo 
        print('''
    Siguientes metodos dispobiles:
    1: Euler
    2: Heun
    3: Runge-Kutta 3
    4: Runge-Kutta 4

    0: Finalizar
''')
        metodo = int(input("Seleccion\t: "))
        if metodo < 1:
            print("\n\nFin de la ejecucion")
            break
        elif metodo > 4: 
            print("No se ha implementado")
            continue
        elif metodo == 1:
            euler(y_0,t_0);
        elif metodo == 2:
            heun(y_0,t_0);
        elif metodo == 3:
            runge_kutta_3(y_0,t_0);
        elif metodo == 4:
            runge_kutta_4(y_0,t_0);

# MATEMATICAS 

def f(t,y):
    return eval(funcion_f)

def f_e(t):
    return eval(funcion_e)

def euler(y,t):
    title("Metodo de Euler")
    muestra(0,t,y)
    for i in range(1,N+1):
        y = y + h*f(t,y)
        t += h
        muestra(i,t,y)
    muestra_err()

def heun(y,t):
    title("Metodo de Heun")
    muestra(0,t,y)
    for i in range(1,N+1):
        y_int = y + h*f(t,y)
        y = y + ((0.5*h)*(f(t,y)+f(t+h,y_int)))
        t += h
        muestra(i,t,y)
    muestra_err()

def runge_kutta_3(y,t):
    title("Metodo de Runge-Kutta de 3er Orden")
    muestra(0,t,y)
    for i in range(1,N+1):
        k_1 = h*f(t,y)
        k_2 = h*f(t+(0.5*h),y+(0.5*k_1))
        k_3 = h*f(t+h,y-k_1+(2*k_2))
        y = y + (1/6)*(k_1+(4*k_2)+k_3)
        t += h
        muestra(i,t,y)
    muestra_err()

def runge_kutta_4(y,t):
    title("Metodo de Runge-Kutta de 4to Orden")
    muestra(0,t,y)
    for i in range(1,N+1):
        k_1 = h*f(t,y)
        k_2 = h*f(t+(0.5*h),y+(0.5*k_1))
        k_3 = h*f(t+(0.5*h),y+(0.5*k_2))
        k_4 = h*f(t+h,y+k_3)
        y = y + (1/6)*(k_1+(2*k_2)+(2*k_3)+k_4)
        t += h
        muestra(i,t,y)
    muestra_err()

# SALIDA DE DATOS

def muestra(i,t,y):
    if debug: 
        print(f"{i} -\tt: {t}\ty: {y}\tErr: {err(y,f_e(t))} %")
    elif quiet:
        # Guarda el error no muestres nada
        err(y,f_e(t))
    elif funcion_e != "":
        print(f"{i} -\tt: {round(t,3)}\ty: {round(y,4)}\tErr: {err(y,f_e(t))} %")
    else:
        print(f"{i} -\tt: {round(t,3)}\ty: {round(y,4)}")

def err(y,y_exac):
    global err_a
    err = 100*(abs(y-y_exac)/abs(y_exac))
    # Log error
    err_a.append(err)
    if debug:
        return err
    return round(err,5)

def muestra_err():
    title(f"\n {N} ejecuciones - Error Promedio : {round(sum(err_a)/len(err_a),20)} %\n","-")
    err_a.clear()

def title(str_title,sep_char="="):
    sep = "\n"
    for i in range(len(str_title)+2):
        sep += sep_char
    print("\n"+sep+"\n "+str_title+sep)

if __name__ == '__main__':
    main()
