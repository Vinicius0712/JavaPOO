import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] idades = new int[5];
        double[] alturas = new double[5];

        int maisVelho = 0, maisNovo = 0, maisBaixo = 0, maisAlto = 0;
        double somaIdade = 0, somaAltura = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Idade da pessoa " + (i + 1) + ": ");
            idades[i] = sc.nextInt();
            System.out.print("Altura da pessoa " + (i + 1) + ": ");
            alturas[i] = sc.nextDouble();

            if (idades[i] > idades[maisVelho]) maisVelho = i;
            if (idades[i] < idades[maisNovo]) maisNovo = i;
            if (alturas[i] > alturas[maisAlto]) maisAlto = i;
            if (alturas[i] < alturas[maisBaixo]) maisBaixo = i;

            somaIdade += idades[i];
            somaAltura += alturas[i];
        }

        double mediaIdade = somaIdade / 5;
        double mediaAltura = somaAltura / 5;

        System.out.println("\nIdades e alturas (ordem inversa):");
        for (int i = 4; i >= 0; i--) {
            System.out.println("Idade: " + idades[i] + " | Altura: " + alturas[i]);
        }

        System.out.println("\nMais velho: " + idades[maisVelho] + " anos, altura " + alturas[maisVelho]);
        System.out.println("Mais novo: " + idades[maisNovo] + " anos, altura " + alturas[maisNovo]);
        System.out.println("Mais alto: " + alturas[maisAlto] + " m, idade " + idades[maisAlto]);
        System.out.println("Mais baixo: " + alturas[maisBaixo] + " m, idade " + idades[maisBaixo]);

        System.out.println("\nMédia de idade: " + mediaIdade);
        System.out.println("Média de altura: " + mediaAltura);

        System.out.println("\nAcima da média:");
        for (int i = 0; i < 5; i++) {
            if (idades[i] > mediaIdade || alturas[i] > mediaAltura) {
                System.out.println("Pessoa " + (i + 1) + " - Idade: " + idades[i] + ", Altura: " + alturas[i]);
            }
        }

        System.out.println("\nAbaixo da média:");
        for (int i = 0; i < 5; i++) {
            if (idades[i] <= mediaIdade || alturas[i] <= mediaAltura) {
                System.out.println("Pessoa " + (i + 1) + " - Idade: " + idades[i] + ", Altura: " + alturas[i]);
            }
        }

        sc.close();
    }
}
