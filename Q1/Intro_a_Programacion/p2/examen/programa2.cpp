#include <iostream>
using namespace std;

int main() 
{
    int pin = 1234, input;
    float saldo= 1000;
    bool exec = true;
    cout << "Inserte su pin para acceder:\t";
    cin >> input;
    
    if(input!=pin) return 0;


    while (exec){
	cout << "Saldo: " << saldo << endl;
	cout << "\tOpciones:\n1.-\tDepositar\n2.-\tRetirar\n(cualquier otro input termina el programa)\nSeleccion:\t";
	cin >> input;
	switch(input){
	    case 1:
		cout << "Ingrese cantidad a depositar:\t";
		cin >> input;
		saldo += input;
		break;
	    case 2:
		do{
		    if(input > saldo) cout << "Retiro imposible; Saldo:\t" << saldo << endl;
		    cout << "Ingresa la cantidad a retirar:\t";
		    cin >> input;
		}while (input > saldo);
		saldo -= input;	
		break;
	    default:
		exec = false;
	}
    }
    return 0;
}
