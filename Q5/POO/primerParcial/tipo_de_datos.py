#palabra = "Asi es mi estimado"
#
#print ( palabra[3:].capitalize())
## --------------------------------------------------------------------------
## EJercicio de los nombres
# 
# # Nombre Completo 
# nombre = input("Inserte su nombre completo (Separado por espacios): ")
# # Edad
# edad = int(input("Dame tu edad: "))
# # Genero 
# genero = input("Que genero eres ?:")
# 
# # logic & Salida
# 
# # Iniciales
# nombres = nombre.split()
# 
# iniciales = ""
# for i in nombres:
#     iniciales = iniciales + i[0]
# 
# iniciales.upper()
# 
# 
# # GEnero
# isMale = genero == "Masculino" or genero == "masculino"
# 
# # NOmbre: Apellido P, Apellido Materno, Nombres
# # Ordenar nombre
# nombres.reverse()
# 
# a_materno = nombres[0]
# a_paterno = nombres[1]
# 
# nombres[0] = a_paterno
# nombres[1] = a_materno
# name_out = ""
# for nombre in nombres:
#     name_out += nombre.capitalize() +", "
# 
# if isMale:
#     gen = "M"
# else:
#     gen = "F"
# 
# print(f"Iniciales: {iniciales} \nNombre: {name_out} \nEdad: {edad}; Genero:{gen}")
## ---------------------------------------------------------------------------------

# Tuplas
## 
## a = ("Hola", "mundo")
## 
## print(f"a:{a}-{type(a)}")
## 
## Ejercicio tuplas ----------------------------------------------------------------
# 
# calif = (8,9,5,10,8,7.2,9,8,8,10)
# 
# ## promedio
# 
# prom = sum(calif)/len(calif)
# 
# ## Calificacion max
# 
# c_max = max(calif)
# 
# ## Claif min
# 
# c_min = min(calif)
# 
# ## moda
# 
# mayor = 0
# for i in calif:
#     x = calif.count(i)
#     if x > mayor:
#         mayor = x
#         moda = i
# 
# 
# 
# ## ordenar
# 
# c_sort = tuple(sorted(calif))
# 
# ## SHow 
# 
# print(f"""
#     las calificaciones: {calif}
# 
#     promedio: {prom}
#     Calificacion maxima: {c_max}
#     Calificacion minima: {c_min}
#     Moda: {moda}
# 
#     Ordenadas: {c_sort}
# 
# """)
# 
## --------------------------------------------------------------------------------

## Ejrcicio Listas -----------------------------------------------------------------
#
#lista = ["celular","laptop","cámara","televiion","bocinas",100,310.28,27.00,1000,120.2,300]
#
#a = lista[5:-1]
#b = lista[0:5] 
#
#a.sort()
#print(a)
#b.sort()
#print(b)
#
## -------------------------------------------------------------------------------

## Ejercicio Conjunto ------------------------------------------------------------
# 
# set1 = {10,20,30,40,50}
# set2 = {60,70,80,90,10}
# 
# print(set1 & set2)
# print(set1|set2)
# print(set1.difference({10,20,30}))
# 
## -------------------------------------------------------------------------------

## Ejercicios Diccionarios -------------------------------------------------------

datos = { 'Queretaro': { 'temp':10,'hum':100 } }

print(datos['Queretaro']['temp'])
