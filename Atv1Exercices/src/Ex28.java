import java.util.Scanner;

public class Ex28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double n1 = sc.nextDouble();
        System.out.print("Digite o segundo número: ");
        double n2 = sc.nextDouble();

        System.out.println("Escolha a operação (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double resultado = 0;
        boolean valido = true;

        switch (op) {
            case '+': resultado = n1 + n2; break;
            case '-': resultado = n1 - n2; break;
            case '*': resultado = n1 * n2; break;
            case '/':
                if (n2 != 0) resultado = n1 / n2;
                else { System.out.println("Divisão por zero!"); valido = false; }
                break;
            default:
                System.out.println("Operação inválida.");
                valido = false;
        }

        if (valido) {
            System.out.println("Resultado: " + resultado);
            System.out.println((resultado % 2 == 0 ? "Par" : "Ímpar"));
            System.out.println((resultado >= 0 ? "Positivo" : "Negativo"));
            System.out.println((resultado == Math.floor(resultado) ? "Inteiro" : "Decimal"));
        }
        sc.close();
    }
}
