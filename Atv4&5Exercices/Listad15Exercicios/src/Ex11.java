import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite várias palavras separadas por ';' :");
        String entrada = sc.nextLine();

        String[] palavras = entrada.split(";");

        System.out.println("Palavras no vetor:");
        for (String palavra : palavras) {
            System.out.println(palavra.trim());
        }

        sc.close();
    }
}
