import java.util.Scanner;

public class Ex23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantidade de turmas: ");
        int t = sc.nextInt();
        int soma = 0;

        for (int i = 1; i <= t; i++) {
            int alunos;
            do {
                System.out.print("Alunos da turma " + i + ": ");
                alunos = sc.nextInt();
            } while (alunos > 40);
            soma += alunos;
        }

        double media = soma / (double)t;
        System.out.println("Média de alunos por turma: " + media);
        sc.close();
    }
}
