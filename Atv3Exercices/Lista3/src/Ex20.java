import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantas notas deseja digitar? ");
        int n = sc.nextInt();

        double soma = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Digite a " + i + "ª nota: ");
            soma += sc.nextDouble();
        }

        double media = soma / n;
        System.out.println("Média das notas = " + media);
        sc.close();
    }
}
