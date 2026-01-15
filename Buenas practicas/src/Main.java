import java.util.Scanner;
public class Main {
    public static double IVA=0.16;
    public static double UMBRAL_DESCUENTO = 1000;
    public static double DESCUENTO=0.10;
    static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
      double subtotal = obtenerDouble (sc, "dame el sub total");
      double total=calculartotal(subtotal);
        System.out.println("total "+total);
    }
    public static double obtenerDouble(Scanner sc,String menseje){
        System.out.println(menseje);
        return sc.nextDouble();
    }
    public static double calculartotal(double subtotal){
        double totalConiva= subtotal + (subtotal*IVA);
        return totalConiva;
    }
    public static double calcularDescuento(double total){
        if (total>UMBRAL_DESCUENTO){
            total=total -(total+DESCUENTO);
        }
        return total;
    }
}
