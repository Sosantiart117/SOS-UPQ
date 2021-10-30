package segundoParcial;

public class Nodo {
    
    private String dato;
    private Nodo siguienteNodo;

    public Nodo(){
        dato="";
        siguienteNodo = null;
    }

    public String getDato() {//Devuelve el valor de dato
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}
