package Interfaces;

public interface ConjuntoTda {
    void inicializarConjunto();
    void agregar(int x);
    void sacar(int x);
    boolean pertenece(int x);
    boolean conjuntoVacio();
    int elegir(); // devuelve un elemento cualquiera del conjunto
}
