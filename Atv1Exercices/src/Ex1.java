import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner maior = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = maior.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = maior.nextDouble();

        if (num1 > num2) {
            System.out.println("O maior número é: " + num1);
        } else if (num2 > num1) {
            System.out.println("O maior número é: " + num2);
        } else {
            System.out.println("Os dois números são iguais.");
        }

        maior.close();
    }
}
