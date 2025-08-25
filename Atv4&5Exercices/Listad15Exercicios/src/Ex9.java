import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um texto: ");
        String texto = sc.nextLine();

        char[] vetor = texto.toCharArray();

        System.out.println("Caracteres no vetor:");
        for (char c : vetor) {
            System.out.print(c + " ");
        }
        sc.close();
    }
}
