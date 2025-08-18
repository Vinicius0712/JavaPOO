import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0;

        while (true) {
            System.out.print("Código do produto (0 para encerrar): ");
            int cod = sc.nextInt();
            if (cod == 0) break;

            System.out.print("Quantidade: ");
            int qtd = sc.nextInt();

            double preco = 0;
            switch (cod) {
                case 100: preco = 1.20; break;
                case 101: preco = 1.30; break;
                case 102: preco = 1.50; break;
                case 103: preco = 1.20; break;
                case 104: preco = 1.30; break;
                case 105: preco = 1.00; break;
                default: System.out.println("Código inválido!"); continue;
            }

            double valor = preco * qtd;
            total += valor;
            System.out.println("Valor do item: R$ " + valor);
        }

        System.out.println("Total do pedido: R$ " + total);
        sc.close();
    }
}
