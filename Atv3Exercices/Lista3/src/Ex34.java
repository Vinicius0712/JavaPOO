import java.util.Scanner;

public class Ex34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        while (true) {
            System.out.print("Digite um número positivo (negativo para parar): ");
            int n = sc.nextInt();
            if (n < 0) break;

            if (n <= 25) c1++;
            else if (n <= 50) c2++;
            else if (n <= 75) c3++;
            else if (n <= 100) c4++;
        }

        System.out.println("[0-25]: " + c1);
        System.out.println("[26-50]: " + c2);
        System.out.println("[51-75]: " + c3);
        System.out.println("[76-100]: " + c4);

        sc.close();
    }
}
