import java.util.Scanner;

public class Ex32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tipo;
        double kg, precoKg = 0, total, desconto = 0;
        String formaPagamento;

        System.out.println("Tipos de carne: File Duplo, Alcatra, Picanha");
        System.out.print("Digite o tipo de carne: ");
        tipo = sc.nextLine().toLowerCase();

        System.out.print("Digite a quantidade em Kg: ");
        kg = sc.nextDouble();
        sc.nextLine();
        
        if (tipo.equals("file duplo")) {
            precoKg = (kg <= 5) ? 4.90 : 5.80;
        } else if (tipo.equals("alcatra")) {
            precoKg = (kg <= 5) ? 5.90 : 6.80;
        } else if (tipo.equals("picanha")) {
            precoKg = (kg <= 5) ? 6.90 : 7.80;
        } else {
            System.out.println("Tipo de carne inválido.");
            sc.close();
            return;
        }

        total = kg * precoKg;

        System.out.print("Forma de pagamento (Dinheiro / Cartao Tabajara): ");
        formaPagamento = sc.nextLine();

        if (formaPagamento.equalsIgnoreCase("Cartao Tabajara")) {
            desconto = total * 0.05;
        }

        double valorFinal = total - desconto;

        System.out.println("\n--- CUPOM FISCAL ---");
        System.out.println("Tipo de carne: " + tipo);
        System.out.printf("Quantidade: %.2f Kg\n", kg);
        System.out.printf("Preço total: R$ %.2f\n", total);
        System.out.println("Pagamento: " + formaPagamento);
        System.out.printf("Desconto: R$ %.2f\n", desconto);
        System.out.printf("Valor a pagar: R$ %.2f\n", valorFinal);

        sc.close();
    }
}
