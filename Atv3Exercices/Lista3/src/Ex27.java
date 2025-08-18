import java.util.Scanner;

public class Ex27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            double total = 0;
            int i = 1;
            while (true) {
                System.out.print("Produto " + i + " (0 para finalizar): R$ ");
                double preco = sc.nextDouble();
                if (preco == 0) break;
                total += preco;
                i++;
            }
            System.out.println("Total: R$ " + total);
            System.out.print("Dinheiro: R$ ");
            double dinheiro = sc.nextDouble();
            System.out.println("Troco: R$ " + (dinheiro - total));
            sc.close();
        }
    }
}
