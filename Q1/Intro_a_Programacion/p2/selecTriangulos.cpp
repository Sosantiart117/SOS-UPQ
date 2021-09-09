#include <iostream>
using namespace std;

int main(){
	int select, l1, l2, l3, res;
	cout << "Escoge que tipo de triangulo calcular:\n\t1.- Equilatero\n\t2.- Isoceles\n\t3.- Escaleno\nSeleccion: ";
	cin >> select;
	switch (select){
		case 1: 
			cout << "Introduzca el lado del triangulo Equilatero: ";
			cin >> l1;
			res = l1 * 3;
			break;
		case 2:
			cout << "Introduzca lados iguales: ";
			cin >> l1;
			cout << "Introduzca el lado distinto: ";
			cin >> l2;
			res = (l1 * 2) + l2;
			break;
		case 3:
			cout << "Introduzca lado a: ";
			cin >> l1;
			cout << "Introduzca lado b: ";
			cin >> l2;
			cout << "Introduzca lado c: ";
			cin >> l3;
			res = l1 + l2 + l3;
			break;
		default :
			cout << "No se especifico triangulo;\n\tOpcion no valida" << endl;
	}
	cout << "El perimertro es: " << res << endl;
	system("pause");
	return 0;
}

