import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos números deseja digitar? ");
        int n = sc.nextInt();

        int menor, maior, soma;
        System.out.print("Digite o 1º número: ");
        int num = sc.nextInt();
        menor = maior = soma = num;

        for (int i = 2; i <= n; i++) {
            System.out.print("Digite o " + i + "º número: ");
            num = sc.nextInt();
            soma += num;
            if (num < menor) menor = num;
            if (num > maior) maior = num;
        }

        System.out.println("Menor valor: " + menor);
        System.out.println("Maior valor: " + maior);
        System.out.println("Soma dos valores: " + soma);
        sc.close();
    }
}
