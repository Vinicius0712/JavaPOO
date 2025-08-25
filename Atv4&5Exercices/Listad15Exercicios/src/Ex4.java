import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] letras = new char[10];
        int qtdConsoantes = 0;

        for (int i = 0; i < letras.length; i++) {
            System.out.print("Digite o " + (i+1) + "º caractere: ");
            letras[i] = sc.next().toLowerCase().charAt(0);
        }

        System.out.println("Consoantes digitadas:");
        for (char c : letras) {
            if ("aeiou".indexOf(c) == -1 && Character.isLetter(c)) {
                System.out.print(c + " ");
                qtdConsoantes++;
            }
        }

        System.out.println("\nTotal de consoantes: " + qtdConsoantes);
        sc.close();
    }
}
