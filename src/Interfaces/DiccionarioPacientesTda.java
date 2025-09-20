package Interfaces;

import Modelos.DatosPaciente;

public interface DiccionarioPacientesTda {
    void inicializarDiccionario();
    void agregar(int dni, String nombre, int edad, String historial);
    void eliminar(int dni);
    boolean claveExiste(int dni);
    DatosPaciente recuperar(int dni); // pre: existe
}
