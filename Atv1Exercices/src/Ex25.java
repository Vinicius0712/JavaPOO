import java.util.Scanner;

public class Ex25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o valor do saque (10 a 600): ");
        int valor = sc.nextInt();

        if (valor < 10 || valor > 600) {
            System.out.println("Valor inválido.");
        } else {
            int notas100 = valor / 100; valor %= 100;
            int notas50 = valor / 50; valor %= 50;
            int notas10 = valor / 10; valor %= 10;
            int notas5 = valor / 5; valor %= 5;
            int notas1 = valor;

            System.out.println(notas100 + " notas de 100");
            System.out.println(notas50 + " notas de 50");
            System.out.println(notas10 + " notas de 10");
            System.out.println(notas5 + " notas de 5");
            System.out.println(notas1 + " notas de 1");
        }
        sc.close();
    }
}
