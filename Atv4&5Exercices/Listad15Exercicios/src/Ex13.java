import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[] vetor3 = new int[20];

        System.out.println("Digite 10 números para o vetor 1:");
        for (int i = 0; i < 10; i++) {
            vetor1[i] = sc.nextInt();
        }

        System.out.println("Digite 10 números para o vetor 2:");
        for (int i = 0; i < 10; i++) {
            vetor2[i] = sc.nextInt();
        }

        int j = 0;
        for (int i = 0; i < 10; i++) {
            vetor3[j++] = vetor1[i];
            vetor3[j++] = vetor2[i];
        }

        System.out.println("Vetor intercalado:");
        for (int num : vetor3) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
