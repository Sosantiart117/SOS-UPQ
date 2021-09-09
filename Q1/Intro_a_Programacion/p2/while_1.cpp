#include <iostream>
using namespace std;

int main(){
	int i = 1, sum=0;
	while(i<=5){
		sum += i;
		i++;
	}
	cout <<"La suma 1+2+3+4+5 = " << sum << endl;
	return 0;
}
