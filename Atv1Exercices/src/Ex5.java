import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner vogal = new Scanner(System.in);

        System.out.print("Digite uma letra: ");
        char letra = vogal.next().toLowerCase().charAt(0);

        if ("aeiou".indexOf(letra) != -1) {
            System.out.println("A letra é uma vogal.");
        } else {
            System.out.println("A letra é uma consoante.");
        }

        vogal.close();
    }
}