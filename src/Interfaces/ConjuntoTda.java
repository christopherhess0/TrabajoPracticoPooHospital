package Interfaces;

public interface ConjuntoTda {
    void inicializarConjunto();
    void agregar(String x);
    void sacar(String x);
    boolean pertenece(String x);
    boolean conjuntoVacio();
    String elegir(); // devuelve un elemento cualquiera del conjunto
}
