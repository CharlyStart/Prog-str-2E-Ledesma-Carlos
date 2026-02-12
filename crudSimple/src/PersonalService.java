import java.io.ObjectInputValidation;
import  java.util.Scanner;
public class PersonalService {
    public void alta(Persona[] personas, Scanner sc) {
        InputValidator input = new InputValidator();

        int id = input.getVlidInt(sc, "Ingresa el ID : ");
        if (id <= 0) {
            System.out.println("ID Invalido");
            return;
        }
        if (verificarId(id, personas)) {
            System.out.println("El ID ya existe");
            return;
        }
        sc.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        if (nombre.isBlank()) {
            System.out.println("Nombre vacío");
            return;
        }
        int indice = obtenerIndice(personas);
        if (indice == -1) {
            System.out.println("Arreglo lleno");
        }
        personas[indice] = new Persona(id, nombre);
        System.out.println("Alta exitosa");
    }

    public void buscar(Persona[] personas, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getVlidInt(sc, "Ingresa ID a buscar");

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.println("Encontrada: " + p);
                return;
            }
        }
        System.out.println("No encontrada");
    }

    public void bajaLogica(Persona[] personas, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getVlidInt(sc, "Ingresa ID para baja lógica: ");

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                p.setActiva(false);
                System.out.println("Baja lógica realizada");
                return;
            }
        }
        System.out.println("No encntrada o ya inactiva");
    }

    public void listaActivas(Persona[] personas) {
        boolean hay = false;
        System.out.println("\n ----PERSONAS ACTIVAS----");

        for (Persona p : personas) {
            if (p != null && p.isActiva()) {
                System.out.println(p);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }

    public void actualizarNombre(Persona[] personas, Scanner sc) {
        InputValidator input = new InputValidator();
        int id = input.getVlidInt(sc, "Ingresa ID actualizar: ");
        sc.nextLine();

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.println("Nuevo nombre");
                String nuevo = sc.nextLine();

                if (nuevo.isBlank()) {
                    System.out.println("Nombre inválido");
                    return;
                }
                p.setNombre(nuevo);
                System.out.println("}Nombre actualizado");
                return;
            }
        }
        System.out.println("No encotrada o inactiva");
    }

    private boolean verificarId(int id, Persona[] personas) {
        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private int obtenerIndice(Persona[] personas) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                return i;
            }
        }

        return -1;
    }
}