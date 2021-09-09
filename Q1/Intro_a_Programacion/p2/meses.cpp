#include <iostream>
#include <string>
using namespace std;

int main(){
	int num;
	string mes;
	cout << "Introduce un numero par seleccionar el mes(1-12): ";
	cin >> num;
	switch (num){
		case 1: 
			mes = "Enero";
			break;
		case 2: 
			mes = "Febrero";
			break;
		case 3: 
			mes = "Marzo";
			break;
		case 4: 
			mes = "Abril";
			break;
		case 5: 
			mes = "Mayo";
			break;
		case 6: 
			mes = "Junio";
			break;
		case 7: 
			mes = "Julio";
			break;
		case 8: 
			mes = "Agosto";
			break;
		case 9: 
			mes = "Septiembre";
			break;
		case 10: 
			mes = "Octubre";
			break;
		case 11: 
			mes = "Noviembre";
			break;
		case 12: 
			mes = "Diciembre";
			break;
		default :
			cout << "Todavia no existe ese mes!" << endl;
	}
	cout << "Escogiste el mes: " << mes << endl;
	system("pause");
	return 0;
}

