import Implementaciones.ConjuntoDinamicoDoctores;
import Interfaces.ConjuntoTda;
import Algoritmos.Algoritmos;

public class Main {
    public static void main(String[] args) {
        ConjuntoDinamicoDoctores listaMedicos = new ConjuntoDinamicoDoctores();
        listaMedicos.agregar("Juan Perez");
        listaMedicos.agregar("Christopher Hess");
        Algoritmos.mostrarConjunto(listaMedicos);
    }

};