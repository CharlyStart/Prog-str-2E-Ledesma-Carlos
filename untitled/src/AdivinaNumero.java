import java.util.Random;
import java.util.Scanner;


public class AdivinaNumero {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        Random random= new Random();
        int minimo=1;
        int maximo=100;
        int intentos=0;
        int limiteIntentos=7;

        int fueraRango = 0;     // contador fuera de rango
        int noNumerico = 0;
        int secreto = random.nextInt(maximo-minimo+1)+minimo; //1...100
        //System.out.println(secreto);
        boolean gano=false; //bandera para saber si gano o no

        System.out.println("Adivina el numero entre (1-100) tienes: "+limiteIntentos);

        while (intentos < limiteIntentos && !gano) {

            int numero = obtenerNumeroValido(
                    minimo, maximo, scanner,
                    "Intento " + (intentos + 1) + ": ",
                    new int[]{0, 0}
            );



            if (numero == secreto) {
                System.out.println("¡Ganaste!");
                gano = true;
            } else if (numero > secreto) {
                System.out.println("El número secreto es menor");
            } else {
                System.out.println("El número secreto es mayor");
            }
        }

        if(!gano){
            System.out.println("Perdiste, el numero secreto era: "+secreto);
        }
        System.out.println("\nEstadísticas:");
        System.out.println("Intentos fuera de rango: " + fueraRango);
        System.out.println("Entradas no numéricas: " + noNumerico);
        scanner.close();

    }
    static int[] contadores = new int[2];

    public static int obtenerNumeroValido(int min, int max, Scanner scanner, String mensaje, int[] dummy) {

        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();

                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Número fuera de rango. Debe ser entre " + min + " y " + max);
                    contadores[0]++; // fuera de rango
                }
            } else {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                scanner.next();
                contadores[1]++; // no numérico
            }
        }
    }

}