import java.util.Scanner;
public class ActividadIfElseTarifa {
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int edad = 0;
        boolean estudiante=true;
        System.out.println("Ingresa tu edad: ");
        edad = sc.nextInt();
        if (edad <12){
            System.out.println("tu tarifa es -> $50");

        }
        else {
            if (edad >=12 && edad <=17){
            System.out.println("eres estudiante true/false: ");
            estudiante = sc.nextBoolean();
            if (estudiante){
                System.out.println("Tu tarifa es ->60");
            }
            }
          else if (!estudiante){
                  System.out.println("Tu tarifa es ->80");
              }


            }
        }
    }

