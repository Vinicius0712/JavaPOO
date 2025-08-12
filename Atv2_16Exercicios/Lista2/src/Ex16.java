import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Área a ser pintada (m²): ");
        double area = in.nextDouble();

        double litros = area / 6.0;

        int latas = (int) Math.ceil(litros / 18.0);
        double precoLatas = latas * 80;

        int galoes = (int) Math.ceil(litros / 3.6);
        double precoGaloes = galoes * 25;

        System.out.println("Usando apenas latas de 18L: " + latas + " latas - R$ " + precoLatas);
        System.out.println("Usando apenas galões de 3,6L: " + galoes + " galões - R$ " + precoGaloes);
        in.close();
    }
}
