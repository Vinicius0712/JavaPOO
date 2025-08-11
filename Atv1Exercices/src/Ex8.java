import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner notas = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = notas.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = notas.nextDouble();

        double media = (nota1 + nota2) / 2;

        if (media >= 7) {
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado.");
        }

        notas.close();
    }
}