import math

def main():
    edad = 1
    while edad != 0 or edad < 0:

        edad = int( input("¿Cual es tu edad?: ") )

        if edad < 0:
            print("No es valida tu edad...")
            continue

        if edad < 18:
            print ("Eres menor de edad y no puedes tomar cerveza")
        elif edad < 21:
            print ("Pudes tomar pero eres muy joven ")
        else:
            print ("Salud")
            break

if __name__ == '__main__':
    main()
