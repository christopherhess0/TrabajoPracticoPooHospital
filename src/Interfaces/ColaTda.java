package Interfaces;

public interface ColaTda {
    void inicializarCola(); // pre: -
    void acolar(int x);     // encola al final
    void desacolar();       // saca el primero (pre: !colaVacia())
    int primero();          // mira el primero (pre: !colaVacia())
    boolean colaVacia();
}
