import java.util.Scanner;

public class Ex26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int num = sc.nextInt();

        System.out.println(num % 2 == 0 ? "Par" : "Ímpar");
        sc.close();
    }
}
