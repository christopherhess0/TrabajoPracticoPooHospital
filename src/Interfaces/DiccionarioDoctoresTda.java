package Interfaces;

import Modelos.DatosMedico;

public interface DiccionarioDoctoresTda {
    void inicializarDiccionario();
    void agregar(String clave, String especialidad, int horaInicio, int horaFin);
    void eliminar(String clave);
    boolean claveExiste(String clave);
    DatosMedico recuperar(String clave); // pre: existe
}
