package Algoritmos;

import Implementaciones.ColaDinamica;
import Implementaciones.ConjuntoDinamicoDoctores;
import Implementaciones.DiccionarioDoctoresDinamico;
import Implementaciones.DiccionarioPacientesDinamico;
import Interfaces.ColaTda;
import Modelos.DatosMedico;
import Modelos.DatosPaciente;

/**
 * Usa SOLO: Conjunto (médicos), Diccionario (pacientes), Cola por especialidad.
 * Especialidades codificadas como enteros para mantenerlo simple.
 * 0=CLINICA, 1=PEDIATRIA, 2=CARDIOLOGIA, 3=TRAUMATOLOGIA, 4=DERMATOLOGIA
 */
public class Hospital {

    // --- TDAs internos ---
    private ConjuntoDinamicoDoctores medicos;         // nombres únicos
    private DiccionarioDoctoresDinamico infoMedico;   // nombre -> (esp, horarios)
    private DiccionarioPacientesDinamico pacientes;   // dni -> datos paciente
    private ColaTda[] colas;                          // una cola por especialidad
    private int[] atendidos;                          // conteo por especialidad

    // --- util nombre de especialidad ---
    private static final String[] ESP = {
            "CLINICA","PEDIATRIA","CARDIOLOGIA","TRAUMATOLOGIA","DERMATOLOGIA"
    };

    public void inicializar() {
        medicos = new ConjuntoDinamicoDoctores();
        medicos.inicializarConjunto();
        infoMedico = new DiccionarioDoctoresDinamico();
        infoMedico.inicializarDiccionario();
        pacientes = new DiccionarioPacientesDinamico();
        pacientes.inicializarDiccionario();
        colas = new ColaTda[ESP.length];
        atendidos = new int[ESP.length];
        for (int i=0;i<ESP.length;i++){
            colas[i] = new ColaDinamica(); colas[i].inicializarCola();
            atendidos[i] = 0;
        }
    }

    // === Médicos ===
    public void altaMedico(String nombre, DatosMedico medico) {
        if (!medicos.pertenece(nombre)) medicos.agregar(nombre);
        infoMedico.agregar(nombre, medico);
    }

    // === Pacientes ===
    public void registrarPaciente(int dni, String nombre, int edad, String historial) {
        pacientes.agregar(dni, nombre, edad, historial);
    }

    // === Turnos ===
    public boolean pedirTurno(int dni, int especialidad) {
        if (!pacientes.claveExiste(dni)) return false;
        colas[especialidad].acolar(dni);
        return true;
    }

    /** Llama al primer paciente de la cola de la especialidad del médico. */
    public int comenzarAtencion(String nombreMedico) {
        DatosMedico dm = infoMedico.recuperar(nombreMedico);
        if (dm == null) return -1; // médico no encontrado en el diccionario
        int idx = indiceEspecialidad(dm.especialidad);
        if (colas[idx].colaVacia()) return -1; // nadie en cola
        int dni = colas[idx].primero();
        colas[idx].desacolar();
        atendidos[idx] = atendidos[idx] + 1;
        return dni;
    }

    public void reporteDiario() {
        System.out.println("== Reporte diario ==");
        for (int i=0;i<ESP.length;i++){
            System.out.println(ESP[i]+": "+atendidos[i]);
        }
    }

    // === Helpers de impresión (simples, no forman parte de TDAs) ===
    public void mostrarMedicos() {
        ConjuntoDinamicoDoctores aux = new ConjuntoDinamicoDoctores();
        aux.inicializarConjunto();

        while (!medicos.conjuntoVacio()) {
            String nom = medicos.elegir();
            DatosMedico dm = infoMedico.recuperar(nom);
            if (dm == null) {
                System.out.println(nom+" | (sin datos) | -");
            } else {
                System.out.println(nom+" | "+dm.especialidad+" | "+dm.horaInicio+"-"+dm.horaFin);
            }
            aux.agregar(nom);
            medicos.sacar(nom);
        }
        while (!aux.conjuntoVacio()){
            String nom = aux.elegir();
            medicos.agregar(nom);
            aux.sacar(nom);
        }
    }

    public void mostrarColas() {
        for (int i=0;i<ESP.length;i++){
            System.out.print(ESP[i]+": ");
            // clonar y mostrar sin perder
            ColaDinamica aux = new ColaDinamica(); aux.inicializarCola();
            while(!colas[i].colaVacia()){
                int dni = colas[i].primero();
                System.out.print(dni+" ");
                aux.acolar(dni);
                colas[i].desacolar();
            }
            while(!aux.colaVacia()){
                int dni = aux.primero();
                colas[i].acolar(dni);
                aux.desacolar();
            }
            System.out.println();
        }
    }

    private int indiceEspecialidad(String nombre) {
        for (int i=0;i<ESP.length;i++) if (ESP[i].equals(nombre)) return i;
        return 0; // fallback
    }
}
