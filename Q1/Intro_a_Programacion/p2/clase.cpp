#include <iostream>
using namespace std;
int main(){
    int n;
    bool huevos= true;
    cout << "Ah ver, atinale puto! "  << endl;
    cin >> n;
    huevos = !(n > 0 && n < 4);
    while (huevos){
	cout << "Huevos!";
	cin >> n;
	huevos = !(n > 0 && n < 4);
    }
    // no sale hasta que n sea positivo y menor a 4
    cout << "Lo lograste pendejo!";
    return 0;
}
