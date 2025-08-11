import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner verifica_numero = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        double num1 = verifica_numero.nextDouble();

        if (num1 > 0) {
            System.out.println("O valor informado é positivo: " + num1);
        } else if (num1 < 0) {
            System.out.println("O valor informado é negativo: " + num1);
        } else {
            System.out.println("O valor informado é zero!");
        }

        verifica_numero.close();
    }
}
