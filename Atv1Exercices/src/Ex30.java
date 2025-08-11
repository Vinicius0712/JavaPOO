import java.util.Scanner;

public class Ex30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tipo de combustível (A-álcool, G-gasolina): ");
        char tipo = sc.next().toUpperCase().charAt(0);

        System.out.print("Digite a quantidade de litros: ");
        double litros = sc.nextDouble();

        double precoLitro = 0, desconto = 0;

        if (tipo == 'A') {
            precoLitro = 4.90;
            desconto = litros <= 20 ? 0.03 : 0.05;
        } else if (tipo == 'G') {
            precoLitro = 5.80;
            desconto = litros <= 20 ? 0.04 : 0.06;
        } else {
            System.out.println("Tipo inválido.");
            sc.close();
            return;
        }

        double total = litros * precoLitro;
        double valorFinal = total - (total * desconto);

        System.out.println("Valor a pagar: R$ " + valorFinal);
        sc.close();
    }
}
