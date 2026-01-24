import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Menu ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multipicacion");
        System.out.println("4. Division");
        System.out.println("Ingresa una opcion: ");
        int opcion = sc.nextInt();

        System.out.println("Dame el primer numero");
        double numero1 = sc.nextDouble();
        System.out.println("Dame el segundo numero");
        double numero2 = sc.nextDouble();
        double resultado;

        switch (opcion){

            case 1:
                resultado = numero1 + numero2;
                System.out.println("Suma ");
                System.out.println("El resultado del numero "+numero1+" y elnumero "+numero2+" es "+resultado);
                break;

            case 2:
                resultado = numero1 - numero2;
                System.out.println("Resta");
                System.out.println("El resultado del numero "+numero1+" y el numero "+numero2+" es "+resultado);
                break;

            case 3:
                resultado = numero1 + numero2;
                System.out.println("Multiplicacion");
                System.out.println("El resusltado del numero "+numero1+" y el numero "+numero2+" es "+resultado);

            case 4:
                System.out.println("Division");
                System.out.println("El numero "+numero1+" y el numero "+numero2);
                if (numero2==0){
                    System.out.println("No se pude dividir entre 0");
                }
                else {
                    resultado = numero1 / numero2;
                    System.out.println("El resultado del numero "+numero1+" y el numero "+numero2+" es "+resultado);
                }
                break;

            default:
                System.out.println("opcion invalida");
                break;
        }
        sc.close();
    }
}
