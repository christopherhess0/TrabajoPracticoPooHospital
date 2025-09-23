import Algoritmos.Hospital;
import Modelos.DatosMedico;
import Modelos.DatosPaciente;

public class Main {
    public static void main(String[] args) {

        Hospital h = new Hospital();
        h.inicializar();

        DatosMedico prueba = new DatosMedico();
        prueba.especialidad = "CARDIOLOGIA";
        prueba.horaInicio = 8;
        prueba.horaFin = 14;

        // === Médicos (conjunto + datos) ===
        // 0=CLINICA, 1=PEDIATRIA, 2=CARDIOLOGIA, 3=TRAUMATOLOGIA, 4=DERMATOLOGIA
        // Aca creamos la instancia
        h.altaMedico("Garcia", prueba);


        System.out.println("-- Médicos --");
        h.mostrarMedicos();

        // === Pacientes (diccionario) ===
        h.registrarPaciente(40894947, "Christopher",   27, "Convulsiones");
        h.registrarPaciente(12345678, "Ana", 30, "Dolor en el pecho");

        // === Turnos (cola por especialidad) ===
        h.pedirTurno(40894947, 2); // Christopher a CARDIOLOGIA
        h.pedirTurno(12345678, 2); // Ana a CARDIOLOGIA

        System.out.println("\n-- Colas --");
        h.mostrarColas();


        // === Atención: el médico llama al primero de SU especialidad ===
        int dni1 = h.comenzarAtencion("Garcia");   // atiende primero de SU especialidad (CARDIOLOGIA)
        System.out.println("\nAtiende Garcia → DNI: " + dni1);

        int dni2 = h.comenzarAtencion("Garcia");   // siguiente de CLINICA
        System.out.println("Atiende Garcia → DNI: " + dni2);


        System.out.println("\n-- Colas luego de atender --");
        h.mostrarColas();

        System.out.println();
        h.reporteDiario(); // reporte por especialidad
    }
}
