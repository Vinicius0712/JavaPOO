import java.io.*;
import java.util.*;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos alunos deseja cadastrar? ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] alunos = new String[n][3]; // nome, nota1, nota2
        double[] medias = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nome do aluno: ");
            alunos[i][0] = sc.nextLine();
            System.out.print("Nota 1: ");
            alunos[i][1] = sc.next();
            System.out.print("Nota 2: ");
            alunos[i][2] = sc.next();
            sc.nextLine();

            double nota1 = Double.parseDouble(alunos[i][1]);
            double nota2 = Double.parseDouble(alunos[i][2]);
            medias[i] = (nota1 + nota2) / 2;
        }

        // Salvar em arquivo
        PrintWriter out = new PrintWriter(new FileWriter("alunos.txt"));
        for (int i = 0; i < n; i++) {
            out.println(alunos[i][0] + ";" + alunos[i][1] + ";" + alunos[i][2] + ";" + medias[i]);
        }
        out.close();

        // Ler do arquivo
        List<String> linhas = new ArrayList<>();
        Scanner arq = new Scanner(new File("alunos.txt"));
        while (arq.hasNextLine()) {
            linhas.add(arq.nextLine());
        }
        arq.close();

        double maiorNota = -1, menorNota = 11;
        String alunoMaiorNota = "", alunoMenorNota = "";
        double maiorMedia = -1, menorMedia = 11;
        String alunoMaiorMedia = "", alunoMenorMedia = "";
        double somaMedias = 0;

        System.out.println("\n--- RELATÓRIO ---");
        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            double n1 = Double.parseDouble(partes[1]);
            double n2 = Double.parseDouble(partes[2]);
            double media = Double.parseDouble(partes[3]);

            System.out.printf("%s - Notas: %.1f, %.1f - Média: %.2f%n", nome, n1, n2, media);
            somaMedias += media;

            if (n1 > maiorNota) { maiorNota = n1; alunoMaiorNota = nome; }
            if (n2 > maiorNota) { maiorNota = n2; alunoMaiorNota = nome; }
            if (n1 < menorNota) { menorNota = n1; alunoMenorNota = nome; }
            if (n2 < menorNota) { menorNota = n2; alunoMenorNota = nome; }

            if (media > maiorMedia) { maiorMedia = media; alunoMaiorMedia = nome; }
            if (media < menorMedia) { menorMedia = media; alunoMenorMedia = nome; }
        }

        double mediaGeral = somaMedias / n;
        System.out.printf("\nMaior nota: %.1f (%s)%n", maiorNota, alunoMaiorNota);
        System.out.printf("Menor nota: %.1f (%s)%n", menorNota, alunoMenorNota);
        System.out.printf("Maior média: %.2f (%s)%n", maiorMedia, alunoMaiorMedia);
        System.out.printf("Menor média: %.2f (%s)%n", menorMedia, alunoMenorMedia);
        System.out.printf("Média geral da turma: %.2f%n", mediaGeral);
        sc.close();
    }
}
