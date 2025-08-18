import java.util.Scanner;

public class Ex29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Montar a tabuada de: ");
        int num = sc.nextInt();
        System.out.print("Começar por: ");
        int ini = sc.nextInt();
        System.out.print("Terminar em: ");
        int fim = sc.nextInt();

        if (fim < ini) {
            System.out.println("Intervalo inválido!");
        } else {
            for (int i = ini; i <= fim; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
            sc.close();
            
        }
    }
}
