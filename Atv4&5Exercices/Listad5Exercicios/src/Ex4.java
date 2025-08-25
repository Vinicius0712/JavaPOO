import java.io.*;
import java.util.*;

public class Ex4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos atletas participarão? ");
        int n = sc.nextInt();
        sc.nextLine();

        double[][] saltos = new double[n][5];
        double[] medias = new double[n];
        String[] nomes = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nome do atleta: ");
            nomes[i] = sc.nextLine();
            double soma = 0, menor = Double.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                System.out.print("Salto " + (j+1) + ": ");
                saltos[i][j] = sc.nextDouble();
                soma += saltos[i][j];
                if (saltos[i][j] < menor) menor = saltos[i][j];
            }
            sc.nextLine();
            medias[i] = (soma - menor) / 4;
        }

        PrintWriter out = new PrintWriter(new FileWriter("saltos.txt"));
        for (int i = 0; i < n; i++) {
            out.print(nomes[i] + ";");
            for (int j = 0; j < 5; j++) out.print(saltos[i][j] + ";");
            out.println(medias[i]);
        }
        out.close();

        Scanner arq = new Scanner(new File("saltos.txt"));
        System.out.println("\n--- RESULTADOS ---");
        double maior = -1, menor = 999;
        String campeao = "", ultimo = "";
        while (arq.hasNextLine()) {
            String[] dados = arq.nextLine().split(";");
            String nome = dados[0];
            double media = Double.parseDouble(dados[6]);
            System.out.print(nome + " - Saltos: ");
            for (int j = 1; j <= 5; j++) System.out.print(dados[j] + " ");
            System.out.printf("- Média: %.2f%n", media);

            if (media > maior) { maior = media; campeao = nome; }
            if (media < menor) { menor = media; ultimo = nome; }
        }
        arq.close();

        System.out.printf("\nCampeão: %s com média %.2f%n", campeao, maior);
        System.out.printf("Último lugar: %s com média %.2f%n", ultimo, menor);
        sc.close();
    }
}
