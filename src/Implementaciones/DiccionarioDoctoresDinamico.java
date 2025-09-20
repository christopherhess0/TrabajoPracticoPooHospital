package Implementaciones;

import Interfaces.DiccionarioDoctoresTda;
import Modelos.DatosMedico;

public class DiccionarioDoctoresDinamico implements DiccionarioDoctoresTda {

    private static class Nodo {
        String clave;
        DatosMedico valor;
        Nodo sig;
    }
    private Nodo primero;

    public void inicializarDiccionario() { primero = null; }

    public void agregar(String clave, String esp, int hi, int hf) {
        Nodo n = buscar(clave);
        if (n == null) {
            n = new Nodo();
            n.clave = clave;
            n.valor = new DatosMedico();
            n.valor.especialidad = esp;
            n.valor.horaInicio = hi;
            n.valor.horaFin = hf;
            n.sig = primero;
            primero = n;
        } else {
            n.valor.especialidad = esp;
            n.valor.horaInicio = hi;
            n.valor.horaFin = hf;
        }
    }

    public void eliminar(String clave) {
        Nodo ant = null, act = primero;
        while (act != null && !act.clave.equals(clave)) { ant = act; act = act.sig; }
        if (act != null) { if (ant == null) primero = act.sig; else ant.sig = act.sig; }
    }

    public boolean claveExiste(String clave) { return buscar(clave) != null; }

    public DatosMedico recuperar(String clave) { return buscar(clave).valor; }

    private Nodo buscar(String clave) {
        Nodo aux = primero;
        while (aux != null && !aux.clave.equals(clave)) aux = aux.sig;
        return aux;
    }
}
