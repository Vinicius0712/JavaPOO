import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] medias = new double[10];
        int aprovados = 0;

        for (int i = 0; i < medias.length; i++) {
            double soma = 0;
            System.out.println("Aluno " + (i+1) + ":");
            for (int j = 1; j <= 4; j++) {
                System.out.print("Nota " + j + ": ");
                soma += sc.nextDouble();
            }
            medias[i] = soma / 4;
            if (medias[i] >= 7.0) aprovados++;
        }

        System.out.println("Número de alunos com média >= 7.0: " + aprovados);
        sc.close();
    }
}
