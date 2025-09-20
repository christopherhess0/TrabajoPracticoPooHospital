package Implementaciones;

import Interfaces.ConjuntoTda;

public class ConjuntoDinamicoDoctores implements ConjuntoTda {

    private static class Nodo {
        String info;
        Nodo sig;
    }

    private Nodo primero;

    @Override
    public void inicializarConjunto() {
        primero = null; // arranca vacío
    }

    @Override
    public void agregar(String x) {
        if (!pertenece(x)) {           // evita duplicados por contenido
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = primero;       // inserción al inicio
            primero = nuevo;
        }
    }

    @Override
    public String elegir() {
        return primero.info;           // pre: conjunto no vacío
    }

    @Override
    public boolean conjuntoVacio() {
        return primero == null;
    }

    @Override
    public void sacar(String x) {
        Nodo ant = null, act = primero;
        while (act != null && !act.info.equals(x)) {
            ant = act;
            act = act.sig;
        }
        if (act != null) {             // encontrado
            if (ant == null) primero = act.sig;
            else ant.sig = act.sig;
        }
    }

    @Override
    public boolean pertenece(String x) {
        Nodo aux = primero;
        while (aux != null && !aux.info.equals(x)) { // compara contenido
            aux = aux.sig;
        }
        return aux != null;
    }
}
