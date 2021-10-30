package segundoParcial;

import javax.swing.JOptionPane;

public class ListaSimple {

    private Nodo primerNodo, ultimoNodo;
    private int size;

    public ListaSimple(){
        primerNodo = null;
        ultimoNodo = null;
    }

    public void AgregarInicio(){
        Nodo nuevoNodo = nuevoNodo();
        if(primerNodo!=null){
            nuevoNodo.setSiguienteNodo(primerNodo);
            primerNodo = nuevoNodo;
        }else{
            ultimoNodo = nuevoNodo;
            primerNodo = ultimoNodo;
        }
    }

    public void AgregarFinal(){
        Nodo nuevoNodo = nuevoNodo();
        if(ultimoNodo != null){
            ultimoNodo.setSiguienteNodo(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }else{
            ultimoNodo = nuevoNodo;
            primerNodo = ultimoNodo;
        }
    }

    public Nodo nuevoNodo(){
        Nodo nuevoNodo = new Nodo();
        String dato = "";

        dato = JOptionPane.showInputDialog("Ingresa tu nombre");
        nuevoNodo.setDato(dato);
        size++;
        return nuevoNodo;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void leerLista(){
        String datos = "[ ";
        if(!isEmpty())
            datos+=leerNodos(primerNodo);
        JOptionPane.showMessageDialog(null, datos);
    }

    private String leerNodos(Nodo nodo){
        if(nodo == null) return "]";
        String dato = "";
        dato = nodo.getDato();
        dato += ", ";
        return dato + leerNodos(nodo.getSiguienteNodo());
    }

    public void removeTop(){
        if(isEmpty()) return;
        Nodo old =  primerNodo;
        primerNodo = primerNodo.getSiguienteNodo();
        JOptionPane.showMessageDialog(null,
                "Se ha eliminado \""+old.getDato()+"\" de la lista");
        size--;
    }

    public void removeTail(){
        if(isEmpty()) return;
        if(size==1) {
            this.removeTop();
            return;
        }
        Nodo old =  ultimoNodo;
        Nodo n = find(primerNodo, size-1, 1);
        n.setSiguienteNodo(null);
        ultimoNodo = n;
        JOptionPane.showMessageDialog(null,
                "Se ha eliminado \""+old.getDato()+"\" de la lista");
        size--;
    }

    public void insert(){
        if(isEmpty()) {
            this.AgregarInicio();
            return;
        }
        int index = -1;
        while (index < 0 || index > size)
            index = Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "Valor del indice para insertar:\n"+
                        "(Valor entre 0 y"+size+")"));
        Nodo nodo = find(primerNodo,index,0);
        Nodo next = nodo.getSiguienteNodo();
        Nodo nuevo = nuevoNodo();
        if(nodo == primerNodo){
            primerNodo = nuevo;
            nuevo.setSiguienteNodo(nodo);
        }else{
            nodo.setSiguienteNodo(nuevo);
            nuevo.setSiguienteNodo(next);
        }
    }

    private Nodo find(Nodo nodo, int index, int count){
        if(nodo.getSiguienteNodo() == null) return nodo;
        if(index == count) return nodo;
        return find(nodo.getSiguienteNodo(), index, count+1);
    }

    public void menu(){
        char op = '\0';

        do {
            op = JOptionPane.showInputDialog(
                    "---- Menu ----\n"+
                    "\n1. Agregar Nombre al inicio"+
                    "\n2. Agregar Nombre al final"+
                    "\n3. Mostrar la lista"+
                    "\n4. Insertar Valor en un indice"+
                    "\n5. Borrar el primer Nombre"+
                    "\n6. Borrar el ultimo Nombre"+
                    "\n8. Salir").charAt(0);

            switch(op){
                case '1':
                    this.AgregarInicio();
                    break;
                case '2':
                    this.AgregarFinal();
                    break;
                case '3':
                    this.leerLista();
                    break;
                case '4':
                    this.insert();
                    break;
                case '5':
                    this.removeTop();
                    break;
                case '6':
                    this.removeTail();
                    break;
                case '7':
                case '8':
                case '9':
                    JOptionPane.showMessageDialog(null, "Adios...");
                    break;
            }
        }while(op!='8');
    
    }
}
