import java.util.Scanner;

public class App {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PersonalService service = new PersonalService();
        Persona[] personas = new Persona[20];
        int opcion;
        do {
            System.out.println("\n ----- MENU -----");
            System.out.println("1. Alta");
            System.out.println("2. Buscar por ID (Solo activas)");
            System.out.println("3. Lista de activas");
            System.out.println("5. Actualizar nombre por ID (Solo activas)");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){

                case 1 -> service.alta(personas, sc);
                case 2 -> service.buscar(personas, sc);
                case 3 -> service.bajaLogica(personas, sc);
                case 4 -> service.listaActivas(personas);
                case 5 -> service.actualizarNombre(personas, sc);
                case 0 -> System.out.println("Programa Finaizado");

            }
        }while (opcion!=0);
    }
}
