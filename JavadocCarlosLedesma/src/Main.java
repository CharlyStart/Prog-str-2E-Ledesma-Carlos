import java.util.Scanner;


public class Main {
    public static double PESO_BAJO=18.5;
    public static double PESO_MEDIO=25;
    public static double PESO_ALTO=30;
    public static void main(String[] args){
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Calcula IMC");
            System.out.println("2. Option B");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            option= sc.nextInt();
            switch (option) {
                case 1:
                    double pesoKg= obtenerDouble(sc,"Ingresa el peso en KG");
                    double alturaM= obtenerDouble(sc,"Ingresa la altura en M -> 1.80");
                    double IMC= calcularIMC(pesoKg,alturaM);
                    System.out.println("IMC: "+IMC);

                    break;
                case 2:
                    System.out.println("You selected Option B.");
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                case 4:
                    System.out.println("E");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();

        } while (option != 5);
    }
            public static double getPesoBajo(){

            }
}
