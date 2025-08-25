import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = 3;
        int[] valores = new int[N];

        for (int i = 0; i < N; i++) {
            int num;
            do {
                System.out.print("Digite um valor entre 0 e 20: ");
                num = sc.nextInt();
            } while (num < 0 || num > 20);

            valores[i] = num;
        }

        System.out.println("\nGráfico:");
        for (int val : valores) {
            System.out.print(val + ": ");
            for (int j = 0; j < val; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        sc.close();
    }
}
