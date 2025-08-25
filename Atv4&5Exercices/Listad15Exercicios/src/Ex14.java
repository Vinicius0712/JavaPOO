import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] idades = new int[30];
        double[] alturas = new double[30];
        double somaAlturas = 0;

        for (int i = 0; i < 30; i++) {
            System.out.print("Idade do aluno " + (i + 1) + ": ");
            idades[i] = sc.nextInt();
            System.out.print("Altura do aluno " + (i + 1) + ": ");
            alturas[i] = sc.nextDouble();
            somaAlturas += alturas[i];
        }

        double mediaAltura = somaAlturas / 30;
        int contador = 0;

        for (int i = 0; i < 30; i++) {
            if (idades[i] > 13 && alturas[i] < mediaAltura) {
                contador++;
            }
        }

        System.out.println("Quantidade de alunos com mais de 13 anos e abaixo da média de altura: " + contador);

        sc.close();
    }
}
