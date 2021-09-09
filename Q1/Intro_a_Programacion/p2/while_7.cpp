#include <iostream>
using namespace std;

int main(){
	int i = 0;
	float n, sum=0;
	while (sum < 300){
		cout << "Introduzca numero hasta llegar a 300: ";
		cin >> n;
		sum += n;
		if(sum > 300){
			sum -= n;
			cout << "Te pasaste, vuelve a intentar!"<<endl;
		}
		i++;
	}
	cout << "La suma es 300!";
	cout << "\tTe tomo " << i << " operaciones" << endl;
	system("PAUSE");
	return 0;
}
