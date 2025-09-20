package Implementaciones;

import Interfaces.ConjuntoTda;

public class ConjuntoDinamicoDoctores implements ConjuntoTda {
    private class datosMedico{
        String Especialidad;
        int HorarioInicio;
        int HorarioFin;
    };
    private class Nodo {
        int info;
        datosMedico datosmedico;
        Nodo sig;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private Nodo primero;

    @Override
    public void inicializarConjunto() {
        primero = null; // arranca vacío
    }

    @Override
    public void agregar(int x) {
        if (!pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = primero;
            primero = nuevo;
        }
    }

    @Override
    public int elegir() {
        return primero.info; // pre: no vacío
    }

    @Override
    public boolean conjuntoVacio() {
        return (primero == null);
    }

    @Override
    public void sacar(int x) {
        Nodo ant = null;
        Nodo act = primero;

        while (act != null && act.info != x) {
            ant = act;
            act = act.sig;
        }

        if (act != null) { // lo encontró
            if (ant == null) { // estaba en la primera posición
                primero = primero.sig;
            } else {
                ant.sig = act.sig;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        Nodo aux = primero;
        while (aux != null && aux.info != x) {
            aux = aux.sig;
        }
        return (aux != null);
    }
}