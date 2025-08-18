import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int n2 = sc.nextInt();

        int soma = 0;
        for (int i = n1 + 1; i < n2; i++) {
            System.out.println(i);
            soma += i;
        }
        System.out.println("Soma dos números no intervalo: " + soma);
        sc.close();
    }
}
