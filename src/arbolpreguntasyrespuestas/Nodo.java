package arbolpreguntasyrespuestas;

public class Nodo {
    Nodo izquierdo;
    Nodo derecho;
    int dato;
    int alturaNodo;
    
    public Nodo(int dato){
        this.izquierdo = null;
        this. derecho = null;
        this.dato = dato;
        this.alturaNodo = 1;
    }
}
