#include <iostream>
using namespace std;

int main(){
	int i = 2, n, sum = 0;
	cout << "Introduzca la cantidad numeros a mostrar: ";
	cin >> n;
	while (i <= n ){
		sum += i;
		cout << sum << endl;
		i+=2;
	}
	return 0;
}
