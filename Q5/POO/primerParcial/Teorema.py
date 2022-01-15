import math

def main():
    c1 = float(input("Dame un numero: "))
    c2 = float(input("Dame un numero: "))

    hip = math.sqrt((c1**2)+(c2**2)).__round__(2)

    print(f"La hipotenusa es {hip}")
    pass

if __name__ == '__main__':
    main()
