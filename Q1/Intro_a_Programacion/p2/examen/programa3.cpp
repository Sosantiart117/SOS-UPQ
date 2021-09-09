#include <iostream>
using namespace std;

int main() 
{
    int suma=0, numeros[]={1 ,2 ,3 ,4 ,5};
    float prom = 0;
    for (int i = 0; i < 5 ;i++){
	suma += numeros[i];
    }
    prom = suma / 5;
    cout << "La suma del vector, es:\t\t" << suma <<endl;
    cout << "El promedio del vector, es:\t" << prom <<endl;
    return 0;
}
