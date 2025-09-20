package Interfaces;

public interface PilaTda {
    // Inicializa la pila vacía
    void inicializarPila();

    // Apila un elemento en el tope
    void apilar(int x);

    // Desapila el tope (elimina el último agregado)
    void desapilar();

    // Retorna el elemento en el tope, sin eliminarlo
    int tope();

    // Indica si la pila está vacía
    boolean pilaVacia();
}