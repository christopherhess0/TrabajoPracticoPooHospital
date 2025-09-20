package Implementaciones;

import Interfaces.ColaTda;

public class ColaDinamica implements ColaTda {
    private static class Nodo {
        int info;
        Nodo sig;
    }
    private Nodo primero, ultimo;

    public void inicializarCola() { primero = ultimo = null; }

    public void acolar(int x) {
        Nodo n = new Nodo(); n.info = x; n.sig = null;
        if (ultimo != null) ultimo.sig = n; else primero = n;
        ultimo = n;
    }

    public void desacolar() { primero = primero.sig; if (primero == null) ultimo = null; }

    public int primero() { return primero.info; }

    public boolean colaVacia() { return primero == null; }
}
