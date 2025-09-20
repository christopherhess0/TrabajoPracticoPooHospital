import Algoritmos.Hospital;
import Modelos.DatosPaciente;

public class Main {
    public static void main(String[] args) {

        Hospital h = new Hospital();
        h.inicializar();

        // === Médicos (conjunto + datos) ===
        // 0=CLINICA, 1=PEDIATRIA, 2=CARDIOLOGIA, 3=TRAUMATOLOGIA, 4=DERMATOLOGIA
        h.altaMedico("Garcia",     0, 8, 12);
        h.altaMedico("Perez",      1,10, 14);
        h.altaMedico("Garcia",     0, 8, 12); // duplicado: no se repite en el conjunto
        h.altaMedico("Fernandez",  2, 9, 13);

        System.out.println("-- Médicos --");
        h.mostrarMedicos();

        // === Pacientes (diccionario) ===
        h.registrarPaciente(40894947, "Christopher",   27, "Convulsiones");

        // === Turnos (cola por especialidad) ===
        h.pedirTurno(40894947, 0); // Christopher a CLINICA

        System.out.println("\n-- Colas --");
        h.mostrarColas();

        // === Atención: el médico llama al primero de SU especialidad ===
        int dni1 = h.comenzarAtencion("Garcia");   // atiende primero de CLINICA
        System.out.println("\nAtiende Garcia → DNI: " + dni1);

        int dni2 = h.comenzarAtencion("Garcia");   // siguiente de CLINICA
        System.out.println("Atiende Garcia → DNI: " + dni2);

        int dni3 = h.comenzarAtencion("Perez");    // primero de PEDIATRIA
        System.out.println("Atiende Perez → DNI: " + dni3);

        System.out.println("\n-- Colas luego de atender --");
        h.mostrarColas();

        System.out.println();
        h.reporteDiario(); // reporte por especialidad
    }
}
