import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite um número: ");
        double numero = in.nextDouble();
        System.out.println("O número informado foi " + numero);
        in.close();
    }
}
