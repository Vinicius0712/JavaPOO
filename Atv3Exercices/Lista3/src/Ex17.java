import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int n = sc.nextInt();

        boolean primo = true;
        if (n < 2) primo = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println(n + " é primo.");
        } else {
            System.out.println(n + " não é primo.");
        }
        sc.close();
    }
}
