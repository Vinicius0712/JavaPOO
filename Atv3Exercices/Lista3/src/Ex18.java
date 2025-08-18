import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int n = sc.nextInt();

        boolean primo = true;
        String divisores = "";

        if (n < 2) primo = false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                primo = false;
                divisores += i + " ";
            }
        }

        if (primo) {
            System.out.println(n + " é primo.");
        } else {
            System.out.println(n + " não é primo. Divisores: " + divisores);
        }
        sc.close();
    }
}
