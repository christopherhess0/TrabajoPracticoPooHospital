package Algoritmos;

import Implementaciones.ConjuntoDinamicoDoctores;

public class Algoritmos {

    public static void mostrarConjunto(ConjuntoDinamicoDoctores c) {
        ConjuntoDinamicoDoctores aux = new ConjuntoDinamicoDoctores();
        aux.inicializarConjunto();

        while (!c.conjuntoVacio()) {
            String x = c.elegir();
            System.out.print(x + ", ");
            aux.agregar(x);
            c.sacar(x);
        }

        // restauramos el conjunto original
        while (!aux.conjuntoVacio()) {
            String x = aux.elegir();
            c.agregar(x);
            aux.sacar(x);
        }

        System.out.println();
    }
}
