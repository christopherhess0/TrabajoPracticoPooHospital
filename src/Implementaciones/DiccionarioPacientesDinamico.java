package Implementaciones;

import Interfaces.DiccionarioPacientesTda;
import Modelos.DatosPaciente;

public class DiccionarioPacientesDinamico implements DiccionarioPacientesTda {

    private static class Nodo {
        int clave; // DNI
        DatosPaciente valor;
        Nodo sig;
    }
    private Nodo primero;

    public void inicializarDiccionario() { primero = null; }

    public void agregar(int dni, String nombre, int edad, String historial) {
        Nodo n = buscar(dni);
        if (n == null) {
            n = new Nodo();
            n.clave = dni;
            n.valor = new DatosPaciente();
            n.valor.nombre = nombre;
            n.valor.edad = edad;
            n.valor.historial = historial;
            n.sig = primero;
            primero = n;
        } else {
            n.valor.nombre = nombre;
            n.valor.edad = edad;
            n.valor.historial = historial;
        }
    }

    public void eliminar(int dni) {
        Nodo ant = null, act = primero;
        while (act != null && act.clave != dni) { ant = act; act = act.sig; }
        if (act != null) { if (ant == null) primero = act.sig; else ant.sig = act.sig; }
    }

    public boolean claveExiste(int dni) { return buscar(dni) != null; }

    public DatosPaciente recuperar(int dni) { return buscar(dni).valor; }

    private Nodo buscar(int dni) {
        Nodo aux = primero;
        while (aux != null && aux.clave != dni) aux = aux.sig;
        return aux;
    }
}
