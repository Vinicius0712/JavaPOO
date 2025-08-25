import java.io.*;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Digite um número ímpar entre 3 e 11: ");
            n = sc.nextInt();
        } while (n < 3 || n > 11 || n % 2 == 0);

        int[][] matriz = new int[n][n];
        int soma = 0, maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
        int pares = 0, impares = 0, diagPrincipal = 0, diagSecundaria = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Digite o valor para [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();

                soma += matriz[i][j];
                if (matriz[i][j] > maior) maior = matriz[i][j];
                if (matriz[i][j] < menor) menor = matriz[i][j];
                if (matriz[i][j] % 2 == 0) pares++;
                else impares++;
                if (i == j) diagPrincipal += matriz[i][j];
                if (i + j == n - 1) diagSecundaria += matriz[i][j];
            }
        }

        double media = (double) soma / (n * n);

        // Exibição formatada
        System.out.println("\nMatriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nSoma: " + soma);
        System.out.printf("Média: %.2f\n", media);
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
        System.out.println("Pares: " + pares);
        System.out.println("Ímpares: " + impares);
        System.out.println("Diagonal Principal: " + diagPrincipal);
        System.out.println("Diagonal Secundária: " + diagSecundaria);
        
        try (PrintWriter out = new PrintWriter("matriz.txt")) {
            out.println("Matriz:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.printf("%4d", matriz[i][j]);
                }
                out.println();
            }
            out.printf("\nSoma: %d\nMédia: %.2f\nMaior: %d\nMenor: %d\n", soma, media, maior, menor);
            out.printf("Pares: %d\nÍmpares: %d\nDiagonal Principal: %d\nDiagonal Secundária: %d\n",
                       pares, impares, diagPrincipal, diagSecundaria);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo.");
      }
      sc.close();
    }
}
