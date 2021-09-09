#include <iostream>
using namespace std;

int main(){
	int i = 0, n;
	do{
		cout << "Introduzca numero que crea correcto: ";
		cin >> n;
		i++;
	}while ( !(n>0 && n<4) );
	cout << "El numero es correcto!";
	cout << "\tTe tomo " << i << " intentos" << endl;
	return 0;
}
