import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numero = leerNumero(scanner);
        int suma = calcularSuma(numero);

        mostrarResultado(suma);

        scanner.close();
    }

    // Lee un número entero
    public static int leerNumero(Scanner scanner) {
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        while (numero <= 0) {
            System.out.print("Error. Ingrese un número mayor que cero: ");
            numero = scanner.nextInt();
        }

        return numero;
    }

    // Calcula la suma usando la fórmula matemática
    public static int calcularSuma(int numero) {
        // Fórmula: n(n + 1) / 2
        return numero * (numero + 1) / 2;
    }

    // Muestra el resultado
    public static void mostrarResultado(int suma) {
        System.out.println("La suma de los números es: " + suma);
    }
}