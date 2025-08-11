import java.util.Scanner;

public class Ex31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double precoMorango, precoMaca;
        double kgMorango, kgMaca, totalKg, total;

        System.out.print("Digite a quantidade (Kg) de morangos: ");
        kgMorango = sc.nextDouble();

        System.out.print("Digite a quantidade (Kg) de maçãs: ");
        kgMaca = sc.nextDouble();

        if (kgMorango <= 5) {
            precoMorango = 2.50;
        } else {
            precoMorango = 2.20;
        }


        if (kgMaca <= 5) {
            precoMaca = 1.80;
        } else {
            precoMaca = 1.50;
        }

        totalKg = kgMorango + kgMaca;
        total = (kgMorango * precoMorango) + (kgMaca * precoMaca);


        if (totalKg > 8 || total > 25.0) {
            total -= total * 0.10;
        }

        System.out.printf("Valor a pagar: R$ %.2f\n", total);

        sc.close();
    }
}