#include <iostream>
using namespace std;

int main(){
	int entrada = 15000, edad;
	float des1 = 1 - .40, des2 = 1 - .30, des3 = 1 - .15;
	cout << "Para entrar al circo, digite su edad: ";
	cin >> edad;
	if(edad <= 4 && edad >= 1){
		entrada *= des1;
	}else if(edad <= 12 && edad >= 5){
		entrada *= des2;
	}else if(edad <= 18 && edad >= 13){
		entrada *= des3;
	}
	cout << "Escribir el precio de la entrada es: " << entrada << endl;
	system("pause");
	return 0;
}
