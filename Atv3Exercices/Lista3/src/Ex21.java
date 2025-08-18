import java.util.Scanner;

public class Ex21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o número de pessoas: ");
        int n = sc.nextInt();
        int soma = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Idade da pessoa " + i + ": ");
            soma += sc.nextInt();
        }

        double media = soma / (double)n;

        if (media >= 0 && media <= 25) {
            System.out.println("Turma Jovem");
        } else if (media <= 60) {
            System.out.println("Turma Adulta");
        } else {
            System.out.println("Turma Idosa");
        }
        sc.close();
    }
}
