import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite sua altura (m): ");
        double altura = in.nextDouble();
        double pesoIdeal = (72.7 * altura) - 58;
        System.out.println("Peso ideal: " + pesoIdeal + " kg");
        in.close();
    }
}
