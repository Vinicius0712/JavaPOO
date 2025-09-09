import java.util.*;

public class Pedido {
    private List<ItemCardapio> cardapio;
    private double total;

    public Pedido() {
        cardapio = new ArrayList<>();
        cardapio.add(new ItemCardapio(100, "Cachorro Quente", 1.20));
        cardapio.add(new ItemCardapio(101, "Bauru Simples", 1.30));
        cardapio.add(new ItemCardapio(102, "Bauru com ovo", 1.50));
        cardapio.add(new ItemCardapio(103, "Hambúrguer", 1.20));
        cardapio.add(new ItemCardapio(104, "Cheeseburguer", 1.30));
        cardapio.add(new ItemCardapio(105, "Refrigerante", 1.00));
        total = 0;
    }

    public void fazerPedido() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o código do item (0 para encerrar): ");
            int codigo = sc.nextInt();
            if (codigo == 0) break;

            ItemCardapio item = buscarItem(codigo);
            if (item == null) {
                System.out.println("Código inválido!");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = sc.nextInt();

            double subtotal = item.getPreco() * qtd;
            total += subtotal;

            System.out.printf("%d x %s = R$ %.2f\n", qtd, item.getNome(), subtotal);
        }
        System.out.printf("TOTAL DO PEDIDO = R$ %.2f\n", total);
        sc.close();
    }

    private ItemCardapio buscarItem(int codigo) {
        for (ItemCardapio item : cardapio) {
            if (item.getCodigo() == codigo) return item;
        }
        return null;
    }
}
