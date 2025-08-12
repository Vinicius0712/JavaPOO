import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        double n1 = in.nextDouble();
        System.out.print("Digite o segundo número: ");
        double n2 = in.nextDouble();
        System.out.println("Soma: " + (n1 + n2));
        in.close();
    }
}
