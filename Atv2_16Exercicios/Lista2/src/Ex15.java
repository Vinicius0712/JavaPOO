import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Área a ser pintada (m²): ");
        double area = in.nextDouble();

        double litros = area / 3.0;
        int latas = (int) Math.ceil(litros / 18.0);
        double preco = latas * 80;

        System.out.println("Latas necessárias: " + latas);
        System.out.println("Preço total: R$ " + preco);
        in.close();
    }
}
