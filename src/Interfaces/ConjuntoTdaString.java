package Interfaces;

public interface ConjuntoTdaString {
    void inicializarConjunto();  // pre: -
    void agregar(String x);      // pre: conjunto inicializado
    void sacar(String x);        // pre: conjunto inicializado
    boolean pertenece(String x); // pre: conjunto inicializado
    boolean conjuntoVacio();     // pre: conjunto inicializado
    String elegir();             // pre: no vacío
}
