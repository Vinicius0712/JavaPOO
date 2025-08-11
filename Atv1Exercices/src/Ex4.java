import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner bis = new Scanner(System.in);

        System.out.print("Digite um ano com 4 dígitos: ");
        int ano = bis.nextInt();

        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
            System.out.println(ano + " é bissexto!");
        } else {
            System.out.println(ano + " não é bissexto!");
        }

        bis.close();
    }
}
