import java.util.Scanner;

public class Ex19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número N: ");
        int n = sc.nextInt();

        int divisoes = 0;
        for (int num = 2; num <= n; num++) {
            boolean primo = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                divisoes++;
                if (num % i == 0) {
                    primo = false;
                    break;
                }
            }
            if (primo) {
                System.out.println(num + " é primo.");
            }
        }

        System.out.println("Número de divisões executadas: " + divisoes);
        sc.close();
    }
}
