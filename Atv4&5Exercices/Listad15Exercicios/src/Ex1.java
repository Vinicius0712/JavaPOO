import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i+1) + "º número inteiro: ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Números digitados:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
