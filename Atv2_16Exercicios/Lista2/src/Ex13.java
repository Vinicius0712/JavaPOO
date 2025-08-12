import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Peso de peixes (kg): ");
        double peso = in.nextDouble();
        double excesso = peso > 50 ? peso - 50 : 0;
        double multa = excesso * 4;
        System.out.println("Excesso: " + excesso + " kg");
        System.out.println("Multa: R$ " + multa);
        in.close();
    }
}
