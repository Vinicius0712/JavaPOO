import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Base: ");
        int base = sc.nextInt();
        System.out.print("Expoente: ");
        int exp = sc.nextInt();

        int resultado = 1;
        for (int i = 1; i <= exp; i++) {
            resultado *= base;
        }

        System.out.println(base + "^" + exp + " = " + resultado);
        sc.close();
    }
}
