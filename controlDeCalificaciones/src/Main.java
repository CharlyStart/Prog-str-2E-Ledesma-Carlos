import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GradeService service = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Nombre del alumno: ");

        double p1 = leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);

        int asistencia = leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);

        boolean entregoProyecto = leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double calificacionFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(
                calificacionFinal, asistencia, entregoProyecto
        );

        imprimirReporte(
                nombre, p1, p2, p3,
                promedio, asistencia,
                entregoProyecto, calificacionFinal, estado
        );

        sc.close();
    }


    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(
            Scanner sc, String msg, double min, double max) {

        double valor;
        do {
            System.out.print(msg);
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        sc.nextLine();
        return valor;
    }

    public static int leerIntEnRango(
            Scanner sc, String msg, int min, int max) {

        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        sc.nextLine();
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        boolean valor = sc.nextBoolean();
        sc.nextLine();
        return valor;
    }



    public static void imprimirReporte(
            String nombre,
            double p1, double p2, double p3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalCalif,
            String estado) {

        System.out.println("\n REPORTE FINAL");
        System.out.println("----------------------------");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.printf("Promedio: %.2f%n", promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.printf("Calificación final: %.2f%n", finalCalif);
        System.out.println("Estado: " + estado);
    }
}



