import java.util.Scanner;

public class Ex33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] gabarito = {'a','a','b','b','c','c','d','d','e','e'};
        char[] respostas = new char[10];
        int acertos = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a resposta da questão " + (i+1) + ": ");
            respostas[i] = sc.next().toLowerCase().charAt(0);
        }

        System.out.println("\n--- RESULTADO ---");
        for (int i = 0; i < 10; i++) {
            if (respostas[i] == gabarito[i]) {
                System.out.println("Q" + (i+1) + ": " + respostas[i] + " : Correto");
                acertos++;
            } else {
                System.out.println("Q" + (i+1) + ": " + respostas[i] + " : Errada, resposta correta (" + gabarito[i] + ")");
            }
        }

        System.out.println("\nTotal de acertos: " + acertos);

        sc.close();
    }
}
