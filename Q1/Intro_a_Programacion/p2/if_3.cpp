#include <iostream>
using namespace std;

int main(){
	double res;
	int a, b, c;
	cout << "Introduzca 3 numeros enteros\nNum1: ";
	cin >> a;
	cout << "Num2: ";
	cin >> b;
	cout << "Num3: ";
	cin >> c;
	if( a = (b + c)){
		cout << "El producto de los 3 numeros es: " << a*b*c<<endl;
	} else if( b = (a + c)){
		cout << "La resta de los 3 numeros es: " << b-a-c<<endl;
	}else if( c = (a + b)){
		cout << "El producto de los 3 numeros es: " << a*b*c<<endl;
	} else {
		cout << "No existe relación"<< endl;	
	}
	return 0;
}
