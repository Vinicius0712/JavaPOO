import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantidade de CDs: ");
        int qtd = sc.nextInt();
        double soma = 0;

        for (int i = 1; i <= qtd; i++) {
            System.out.print("Valor do CD " + i + ": ");
            soma += sc.nextDouble();
        }

        System.out.println("Total investido: R$ " + soma);
        System.out.println("Média por CD: R$ " + (soma / qtd));
        sc.close();
    }
}
