#include <iostream>
#include <string>
using namespace std;
int main() {
    //arreglo útil
    string datos[] = { "Nombre:\t\t", "Apellido:\t", "Genero:\t\t", "Edad:\t\t", "Código:\t\t" }; 
    //definir cuantos datos quiere el usuario
    int n;
    cout << "Cuantos alumnos quieres introducir: ";
    cin >> n;
    // Declarar teniendo en cuenta los datos que pide el usuario
    string baseDeDatos[4][n];
    int matriculas[n];
    cout << "Introduce los siguientes datos" << endl;
    // ciclo para introducir datos 
    for (int i = 0 ; i < n ; i++) {
        cout << "\tAlumno " << i + 1 << endl;
        for ( int j = 0 ; j <= 4 ; j++) {
            cout << datos[j];
            cin >> baseDeDatos[j][i];
        }
    }    
    string codi; 
    cout << "Introducir matricula del alumno que quiere ver: ";
    cin >> codi;
    int i = 0;
    while(codi != baseDeDatos[4][i]) i++;
    for ( int j = 0 ; j <= 4 ; j++) {
        cout << "\t" << datos[j] << baseDeDatos[j][i] << endl;
    }
    return 0;
}