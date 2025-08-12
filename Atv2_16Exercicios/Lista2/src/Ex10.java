import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o primeiro número inteiro: ");
        int n1 = in.nextInt();
        System.out.print("Digite o segundo número inteiro: ");
        int n2 = in.nextInt();
        System.out.print("Digite um número real: ");
        double n3 = in.nextDouble();

        System.out.println("a) " + ((n1 * 2) * (n2 / 2.0)));
        System.out.println("b) " + ((n1 * 3) + n3));
        System.out.println("c) " + Math.pow(n3, 3));
        in.close();
    }
}
