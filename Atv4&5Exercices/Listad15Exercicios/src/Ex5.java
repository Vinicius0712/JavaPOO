import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[20];
        int[] pares = new int[20];
        int[] impares = new int[20];
        int qtdPares = 0, qtdImpares = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i+1) + "º número: ");
            numeros[i] = sc.nextInt();

            if (numeros[i] % 2 == 0) {
                pares[qtdPares++] = numeros[i];
            } else {
                impares[qtdImpares++] = numeros[i];
            }
        }

        System.out.print("Todos: ");
        for (int n : numeros) System.out.print(n + " ");
        System.out.print("\nPares: ");
        for (int i = 0; i < qtdPares; i++) System.out.print(pares[i] + " ");
        System.out.print("\nÍmpares: ");
        for (int i = 0; i < qtdImpares; i++) System.out.print(impares[i] + " ");

        sc.close();
    }
}
