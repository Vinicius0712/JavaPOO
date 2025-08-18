import java.util.Scanner;

public class Ex33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor da dívida: ");
        double divida = sc.nextDouble();

        int[] parcelas = {1, 3, 6, 9, 12};
        int[] juros = {0, 10, 15, 20, 25};

        System.out.println("Valor da Dívida | Juros | Parcelas | Valor da Parcela");

        for (int i = 0; i < parcelas.length; i++) {
            double valorJuros = divida * juros[i] / 100.0;
            double total = divida + valorJuros;
            double valorParcela = total / parcelas[i];

            System.out.printf("R$ %.2f | R$ %.2f | %d | R$ %.2f%n",
                    total, valorJuros, parcelas[i], valorParcela);
        }

        sc.close();
    }
}
