import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double soma = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Digite a " + i + "ª nota: ");
            soma += sc.nextDouble();
        }

        double media = soma / 3;

        if (media == 10) {
            System.out.println("Aprovado com Distinção. Média: " + media);
        } else if (media >= 7) {
            System.out.println("Aprovado. Média: " + media);
        } else {
            System.out.println("Reprovado. Média: " + media);
        }
        sc.close();
    }
}
