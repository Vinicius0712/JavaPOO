import java.io.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] precos = new double[5][5]; // 5 produtos x 5 supermercados
        double[] mediaProdutos = new double[5];
        double[] somaMercados = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("\nSupermercado " + (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.print("Digite o preço do produto " + (j + 1) + ": ");
                precos[i][j] = sc.nextDouble();
                somaMercados[i] += precos[i][j];
                mediaProdutos[j] += precos[i][j];
            }
        }

        for (int j = 0; j < 5; j++) {
            mediaProdutos[j] /= 5;
        }

        double menor = somaMercados[0], maior = somaMercados[0];
        int indiceMenor = 0, indiceMaior = 0;
        for (int i = 1; i < 5; i++) {
            if (somaMercados[i] < menor) {
                menor = somaMercados[i];
                indiceMenor = i;
            }
            if (somaMercados[i] > maior) {
                maior = somaMercados[i];
                indiceMaior = i;
            }
        }

        System.out.println("\nPreços informados:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Supermercado " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                System.out.printf("R$ %.2f ", precos[i][j]);
            }
            System.out.printf(" | Total: R$ %.2f\n", somaMercados[i]);
        }

        System.out.println("\nMédia de preços por produto:");
        for (int j = 0; j < 5; j++) {
            System.out.printf("Produto %d: R$ %.2f\n", (j + 1), mediaProdutos[j]);
        }

        System.out.printf("\nSupermercado mais barato: %d (R$ %.2f)\n", indiceMenor + 1, menor);
        System.out.printf("Supermercado mais caro: %d (R$ %.2f)\n", indiceMaior + 1, maior);

        // Gravar em arquivo
        try (PrintWriter out = new PrintWriter("supermercados.txt")) {
            out.println("Preços informados:");
            for (int i = 0; i < 5; i++) {
                out.print("Supermercado " + (i + 1) + ": ");
                for (int j = 0; j < 5; j++) {
                    out.printf("R$ %.2f ", precos[i][j]);
                }
                out.printf(" | Total: R$ %.2f\n", somaMercados[i]);
            }

            out.println("\nMédia de preços por produto:");
            for (int j = 0; j < 5; j++) {
                out.printf("Produto %d: R$ %.2f\n", (j + 1), mediaProdutos[j]);
            }

            out.printf("\nSupermercado mais barato: %d (R$ %.2f)\n", indiceMenor + 1, menor);
            out.printf("Supermercado mais caro: %d (R$ %.2f)\n", indiceMaior + 1, maior);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo.");
        }
        sc.close();
    }
}
