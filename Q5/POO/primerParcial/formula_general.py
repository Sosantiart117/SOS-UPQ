import math

## En esta seccion de input es que mostramos la parte fundamental de 
## la Ecuacion General para que el usuario nos introduzca los valores
## correctos en las varibales a, b y c

# input
print("""
==========================================================
|    Este es un programa que se usa para encontrar la    |
|    las raices reales de la ecuacion general de 2do     |
|    grado:                                              |
|                                                        |
|                    ax^2 + bx + c = 0                   |
|                                                        |
==========================================================
""")

a = float( input("Introduce el valor a: ") )
b = float( input("Introduce el valor b: ") )
c = float( input("Introduce el valor c: ") )

## Todos los inputs se tratan como floats para tener en cuenta 
## que pueden ser numeros racionales y esto nos permite guardar
## los decimales.

print("""

La ecuacion es:\n
                  ({:0.0f})x^2 + ({:0.0f})x + ({:0.0f}) = 0               

""".format(a,b,c))

## Aqui presentamos la informacion con formato para que el 
## usuario pueda verificar que los valores que introdujo son
## los adecuado

# logic
delta = b**2 - 4*(a*c)
# Si es negaativo: No solucion
if delta < 0:
    res = "Esta funcion no tiene una solucion real para x"
# Si no es 0: unica solucion
elif  delta == 0:
    x = float(-(b)/(2*a))
    res = f"Tiene una unica Solucion x = {x}"
# si es mayor a 0: 2 soluciones
else:
    x1 = float((-b + delta)/(2*a))
    x2 = float((-b - delta)/(2*a))
    res = f"Tiene 2 solucion x_1 = {x1} y x_2 = {x2}"

# Salida x1 y x2
print(res+"\n")

## Aqui hacemos la logica en cuanto a la seleccion pertinente 
## (Como parte del requerimiento) y solo hacemos el cálculo
## Necesario para cada caso. Despues de esto se guarda el resultado
## Y esa variables indistitamente de que camino haya tomado
## Se presenta al usuario
