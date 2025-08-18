import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número de termos: ");
        int n = sc.nextInt();

        double s = 0;
        int denominador = 1;
        for (int i = 1; i <= n; i++) {
            s += (double) i / denominador;
            denominador += 2;
        }

        System.out.println("S = " + s);
        sc.close();
    }
}
