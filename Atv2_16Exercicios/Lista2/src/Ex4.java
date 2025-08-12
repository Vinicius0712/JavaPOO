import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double soma = 0;
        for (int i = 1; i <= 4; i++) {
            System.out.print("Digite a nota " + i + ": ");
            soma += in.nextDouble();
        }
        System.out.println("Média: " + (soma / 4));
        in.close();
    }
}
