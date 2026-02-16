import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorAlumnos gestor = new GestorAlumnos();
        int opcion;

        do {
            System.out.println("\n--- MENU ALUMNOS ---");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja lógica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Promedio: ");
                    double promedio = sc.nextDouble();

                    if (gestor.alta(id, nombre, promedio)) {
                        System.out.println("Alumno registrado");
                    } else {
                        System.out.println("Datos inválidos o ID repetido");
                    }
                }

                case 2 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    Alumnos a = gestor.buscarActivo(id);

                    if (a != null) {
                        System.out.println(a.id + " | " + a.nombre + " | " + a.promedio);
                    } else {
                        System.out.println("Alumno activo no encontrado");
                    }
                }

                case 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Nuevo promedio: ");
                    double nuevo = sc.nextDouble();

                    if (gestor.actualizarPromedio(id, nuevo)) {
                        System.out.println("Promedio actualizado");
                    } else {
                        System.out.println("Error al actualizar");
                    }
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    if (gestor.bajaLogica(id)) {
                        System.out.println("Alumno dado de baja");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                }

                case 5 -> gestor.listarActivos();
                case 6 -> gestor.reportes();
                case 0 -> System.out.println("Fin del programa");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}
