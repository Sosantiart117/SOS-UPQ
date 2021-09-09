#include <iostream>
#include <cmath>
using namespace std;

int main(){
	double res;
	int m, n;
	cout << "Introduzca 2 numeros enteros\nNum1: ";
	cin >> m;
	cout << "Num2: ";
	cin >> n;
	if(n < m){
		res = n * m;
	}else{
		res = sqrt(m);
	};
	cout << "El resultado es: " << res << endl;
	system("pause");
	return 0;
}
