#include <iostream>
using namespace std;

int main(){
    int dato, i = 1;
    float media = 0;
    cout << "Introducir numeros para dar el promedio solo enteros\nPoner 0 para promediar:" << endl ;
    do{
		cout << "Numero " << i << ":";
		cin >> dato ;
		if(!dato){
		    i--;
		    cout << "Haciendo media de " << i << " numeros" << endl;
		}else{
		    media += dato; 
		    i++;
		};
    }while(dato);
    if(media){
		media = media / i ;
		cout << "La media de los numeros es igual a: " << media << endl;
    }else{
		cout << "No inserto ningun numero" << endl;
    };
    system("Pause");
    return 0;
}
