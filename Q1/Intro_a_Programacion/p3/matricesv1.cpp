#include <iostream>
#include <string>
#include <conio.h>
using namespace std;

string get_psk() {
    //censura contraseña
    char passw[32];
    int i = 0, letra;
    while(1) {
	letra = 0;
	letra=getch();
	switch (letra){
	    case 10: // enter o 'Return'
	    {
		passw[i]='\0';
		string str(passw);
		return str;
	    }
	    case 127: //borrar 'Backspace'
	    {
		cout<<"\b \b";
		i--;
	    }
	    default: // cualquier otra letra carácter
	    {
		passw[i] = letra;
		cout << "*";
		i++;
	    }
	}
    }
}

int main() 
{
    //datos
    bool logged = false;
    string sUser[] = {"admin","admin"}, login[2], datos[] = {"Matricula","Evidencia de Conocimiento","Evidencia de Desempeño","Evidencia de Producto", "Calificación Final"};
    int intentos=0;
    float equipo[][5] = {
		{120036750.0, 3.0, 4.0, 3.0, 10.0}, 
		{120034163.0, 3.0, 4.0, 3.0, 10.0},
		{120034142.0, 2.88, 4.0, 3.0, 9.9}, 
		{119033777.0, 2.76, 4.0, 3.0, 9.8},
		{120033778.0, 2.76, 4.0, 3.0, 9.8},
		{120034525.0, 3.0, 4.0, 3.0, 10.0}
    };
    //login
    do{
	if(intentos > 2){ 
	    cout << "No se pudo entrar, hablar con servicio técnico"; 
	    return 0;
	}
	cout << "Usuario:\t";
	getline(cin,login[0]);
	cout << "Contraseña:\t";
	login[1] = get_psk();
	cout << endl;
	intentos++;
	logged = sUser[0] == login[0] && sUser[1] == login[1];
	if(!logged) cout << "Usuario y/o contraseña erróneo" << endl;
    }while(!logged);
    cout << endl;
    cout << "\nBienvenido: " << login[0] << endl << endl; 
    //Enseña datos
    for(int i = 0 ; i < 5 ; i++) cout << datos[i] << "\t";
    cout << endl << endl;
    for(int i = 0 ; i < 6 ; i++) {
        for(int j = 0; j < 5 ; j++) {
                if(j==0) {
                        cout.precision(0);
                        cout << fixed << equipo[i][j] << "\t\t\t";
                } else {
                        cout.precision(2);
                        cout << fixed << equipo[i][j] << "\t\t\t";
                }
        }
        cout << endl;
    }
    return 0;
}
