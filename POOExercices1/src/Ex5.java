import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Exercício 5 ===");
        Pedido pedido = new Pedido();
        pedido.fazerPedido();

        sc.close();
    }
}
