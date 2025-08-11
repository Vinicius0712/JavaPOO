import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double n1 = sc.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double n2 = sc.nextDouble();

        double media = (n1 + n2) / 2;
        String conceito;
        String situacao;

        if (media >= 9) {
            conceito = "A"; situacao = "APROVADO";
        } else if (media >= 7.5) {
            conceito = "B"; situacao = "APROVADO";
        } else if (media >= 6) {
            conceito = "C"; situacao = "APROVADO";
        } else if (media >= 4) {
            conceito = "D"; situacao = "REPROVADO";
        } else {
            conceito = "E"; situacao = "REPROVADO";
        }

        System.out.println("Notas: " + n1 + " e " + n2);
        System.out.println("Média: " + media);
        System.out.println("Conceito: " + conceito);
        System.out.println(situacao);

        sc.close();
    }
}

