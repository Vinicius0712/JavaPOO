import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a " + (i+1) + "ª nota: ");
            notas[i] = sc.nextDouble();
            soma += notas[i];
        }

        System.out.println("Notas digitadas:");
        for (double n : notas) {
            System.out.print(n + " ");
        }

        double media = soma / notas.length;
        System.out.println("\nMédia: " + media);
        sc.close();
    }
}
