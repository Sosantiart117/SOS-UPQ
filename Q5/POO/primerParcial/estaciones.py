## Software para las estaciones

## Input
## El usuario nos da el dia y el mes
# Instrucciones
print("""

      Este programa regresa la estacion de cierta
      fecha dada:

""")

dia_meses = (31,29,31,30,31,30,31,31,30,31,30,31)

## Ciclo para hacer el manejo de excepciones en cuanto a formato invalido
while True:
    try:
        mes = int(input("\t¿Que mes?\n\t> "))
        # Un mes no puede ser menor o igual a 0 ni tampoco ser mayor al limite de meses
        if mes > len(dia_meses) or mes <=0:
            raise Exception("Mes invalido")
        break
    except(TypeError):
        print("Error de tipo, introduzca un valor correcto")
    except(Exception):
        print("\n\t\tMes invalido\n")
        continue

## Ciclo para hacer el manejo de excepciones en cuanto a formato invalido
while True:
    try:
        dia = int(input("\t¿Que dia?\n\t> "))
        # Un dia no puede ser menor o igual a 0 ni tampoco ser mayor al limite del mes
        if dia > dia_meses[mes-1] or dia <= 0:
            raise Exception("Dia invalido")
        break
    except(TypeError):
        print("Error de tipo, introduzca un valor correcto")
        continue
    except(Exception):
        print("\n\t\tDia invalido\n")
        continue


## LOGIC
## Hacemos un cambio de variable al mes 0 
## para casos donde entre a invierno...
if mes == 12 and dia >=21:
    fecha = (dia,0)
else:
    fecha = (dia,mes)
## Las fechas se guardan en una tupla (dia,mes)
## Las estaciones estan en un rango
## STRUCT: "estacion":(tupla_inicio,tupla_final)
rangos = {
    'invierno':((21,0),(20,3)),
    'primavera':((21,3),(21,6)),
    'verano':((22,6),(22,9)),
    'otoño':((23,9),(20,12))
}


## Algoritmo
for estacion in rangos:
    inicio = rangos[estacion][0]
    final = rangos[estacion][1]
    if fecha[1] >= inicio[1] and fecha[1] <= final[1]:
        if (not (inicio[1] == fecha[1]) or fecha[0] >= inicio[0]) and (not (final[1] == fecha[1]) or fecha[0]<=final[0]):
            res = estacion
            break

## OUTPUT 
print(f"""

    La estacion para {dia}/{mes} = {res.capitalize()}

""")
