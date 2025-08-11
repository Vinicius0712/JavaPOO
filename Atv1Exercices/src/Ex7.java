import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner verifica_num = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int a = verifica_num.nextInt();

        System.out.print("Digite o segundo número: ");
        int b = verifica_num.nextInt();

        System.out.print("Digite o terceiro número: ");
        int c = verifica_num.nextInt();

        if (a >= b && a >= c) {
            if (b >= c) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + c + " " + b);
            }
        } else if (b >= a && b >= c) {
            if (a >= c) {
                System.out.println(b + " " + a + " " + c);
            } else {
                System.out.println(b + " " + c + " " + a);
            }
        } else {
            if (a >= b) {
                System.out.println(c + " " + a + " " + b);
            } else {
                System.out.println(c + " " + b + " " + a);
            }
        }

        verifica_num.close();
    }
}
