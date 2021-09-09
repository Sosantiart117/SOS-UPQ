#-------------------------------------------------------- Primera parte
# Un buen programador pone comentarios

# Input del usario
x=int(input("Introduce un numero\"n1\": "))
y=int(input("Introduce un numero\"n2\": "))

# Evaluaciones
print("n1 mayor que n2: \t\t"+ str(x > y))
print("n1 menor que n2: \t\t"+ str(x < y))
print("n1 igual a n2: \t\t"+ str(x == y))
print("n1 diferente n2: \t\t"+ str(x != y))
print("n1 mayor o igual que n2: \t\t"+ str(x >= y))
print("n1 menor o igual que  n2: \t\t"+ str(x <= y))

# AND

# Solicitamos 4 numeros del usuario:
x1=int(input("Introduce el primer numero \"x1\"\t\t: "))
x2=int(input("Introduce el segundo numero \"x2\"\t: "))
y1=int(input("Introduce el tercero numero \"y1\"\t: "))
y2=int(input("Introduce el cuarto numero \"y2\"\t\t: "))

# Tabla de verdad del and
print("Funcion AND:'x1 op y1 AND x2 op y2'\nDonde 'op' se define cada linea")
print("mayor que : \t\t"+ str(x1 > y1 and x2 > y2))
print("menor que : \t\t"+ str(x1 < y1 and x2 < y2))
print("igual a : \t\t"+ str(x1 == y1 and x2 == y2))
print("diferente : \t\t"+ str(x1 != y1 and x2 != y2))
print("mayor o igual que : \t"+ str(x1 >= y1 and x2 >= y2))

# OR

# Solicitamos 4 numeros del usuario:
x1=int(input("Introduce el primer numero \"x1\"\t\t: "))
x2=int(input("Introduce el segundo numero \"x2\"\t: "))
y1=int(input("Introduce el tercero numero \"y1\"\t: "))
y2=int(input("Introduce el cuarto numero \"y2\"\t\t: "))

# Tabla de verdad del or
print("Funcion or:'x1 op y1 OR x2 op y2'\nDonde 'op' se define cada linea")
print("mayor que : \t\t"+ str(x1 > y1 or x2 > y2))
print("menor que : \t\t"+ str(x1 < y1 or x2 < y2))
print("igual a : \t\t"+ str(x1 == y1 or x2 == y2))
print("diferente : \t\t"+ str(x1 != y1 or x2 != y2))
print("mayor o igual que : \t"+ str(x1 >= y1 or x2 >= y2))
print("menor o igual que  : \t"+ str(x1 <= y1 or x2 <= y2))

# NOT

# Solicitamos 2 numeros del usuario:
x1=int(input("Introduce el primer numero \"x1\"\t\t: "))
y1=int(input("Introduce el segundo numero \"y1\"\t: "))

# Tabla de verdad del or
print("Funcion not:'NOT x1 op y1'\nDonde 'op' se define cada linea")
print("mayor que : \t\t"+ str(not x1 > y1))
print("menor que : \t\t"+ str(not x1 < y1))
print("igual a : \t\t"+ str(not x1 == y1))
print("diferente : \t\t"+ str(not x1 != y1))
print("mayor o igual que : \t"+ str(not x1 >= y1))
print("menor o igual que  : \t"+ str(not x1 <= y1))

# ------------------------------------------------------------------- Segunda parte

# Inciso a
# vars
x = 23
# exec
print(str(not(x > 15 and x < 45)))
print(str(not(x > 10 or x < 5)))
print(str(x > 15 and x < 45))


# Inciso b
# vars
a = 25 
b = a 
c = 14 
d = 5
# exec
print(str((a == b or b > c) or c < d))
print(str((a == b and b > c) or c > d))
print(str((a == b and b > c) and c > d))

# Inciso c
# vars
a = 12 
b = 14 
c = 16
d = 19
# exec
print(str((a > b or a < c) and (a == c or  a >= b)))
print(str((a >= b and a < d) and (a >= c or  a >= b)))
print(str((a < b and a < d) and (a <= c and c > d)))
print(str((a > b and a < c) or (a == c and a >= b)))
