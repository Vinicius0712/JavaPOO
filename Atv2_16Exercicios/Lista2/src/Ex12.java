import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite sua altura (m): ");
        double altura = in.nextDouble();
        System.out.print("Digite seu sexo (M/F): ");
        char sexo = in.next().toUpperCase().charAt(0);

        if (sexo == 'M') {
            System.out.println("Peso ideal: " + ((72.7 * altura) - 58) + " kg");
        } else {
            System.out.println("Peso ideal: " + ((62.1 * altura) - 44.7) + " kg");
        }
        in.close();
    }
}
