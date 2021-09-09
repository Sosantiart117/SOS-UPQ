#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() 
{
    int numV = 0, base = 200;
    cout << "introducir el numero de vendedores: ";
    cin >> numV;
    int vendedores[numV+1], contadores[9], rangos[9], rangeC = 200;
    float fact = 0.09;
    
    //determinar rangos
    for(int i = 0; i < 9; i++)
    {
	contadores[i] = 0;
	rangos[i] = rangeC;
	rangeC += 100;
    }
    //Mostrar rangos (debug)
    //	for(int i = 0; i < 9; i++)
    //		cout << rangos[i] << endl;

    //leer datos 
    cout << "Introducir ¿cuanto vendió cada vendedor?:\t" << endl;
    for(int i = 0; i < numV ; i++){
	int venta;
	cout << "Vendedor" << i+1 << " :\t";
	cin >> venta;
	vendedores[i] = base + (venta * fact);
    }

    //Mostrar vendedores (debug)
    //	for(int i = 0; i < numV; i++)
    //		cout << vendedores[i] << endl;

    //encontrar rangos
    for(int i = 0; i < numV; i++)
    {
	for(int j = 0; j < 9; j++)
	{
	    if(vendedores[i] >= rangos[j] && vendedores[i] <= (rangos[j] + 99))
		contadores[j]++;
	}
    }

    //mostrar datos
    string rangosString[] = {"a) $200-299", "b) $300-399", "c) $400-499", "d) $500-599", "e) $600-699", "f) $700-799", "g) $800-899 ", "h) $900-999", "i) $1000"};
    cout << "Rango\t\tVendedores" << endl;
    for(int i = 0; i < 9 ; i++)
	cout << rangosString[i] << "\t" << contadores[i] << endl;

    return 0;
}
