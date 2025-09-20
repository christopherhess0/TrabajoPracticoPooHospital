package Implementaciones;

import Interfaces.ConjuntoTdaString;

public class ConjuntoDinamicoDoctores implements ConjuntoTdaString {

    private static class Nodo {
        String info;
        Nodo sig;
    }

    private Nodo primero;

    public void inicializarConjunto() { primero = null; }

    public void agregar(String x) {
        if (!pertenece(x)) {
            Nodo n = new Nodo();
            n.info = x;
            n.sig = primero;
            primero = n;
        }
    }

    public void sacar(String x) {
        Nodo ant = null, act = primero;
        while (act != null && !act.info.equals(x)) { ant = act; act = act.sig; }
        if (act != null) {
            if (ant == null) primero = act.sig;
            else ant.sig = act.sig;
        }
    }

    public boolean pertenece(String x) {
        Nodo aux = primero;
        while (aux != null && !aux.info.equals(x)) aux = aux.sig;
        return aux != null;
    }

    public boolean conjuntoVacio() { return primero == null; }

    public String elegir() { return primero.info; } // pre: no vacío
}
