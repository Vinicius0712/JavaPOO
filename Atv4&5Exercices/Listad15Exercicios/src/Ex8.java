import java.util.*;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rand = new Random();

        System.out.print("Digite o tamanho da senha desejada: ");
        int tamanho = sc.nextInt();

        if (tamanho >= alfabeto.length || tamanho < 2) {
            System.out.println("Tamanho inválido!");
        } else {
            StringBuilder senha = new StringBuilder();
            String consoantes = "bcdfghjklmnpqrstvwxyz";
            String vogais = "aeiou";

            for (int i = 0; i < tamanho; i++) {
                if (i % 2 == 0) {
                    senha.append(consoantes.charAt(rand.nextInt(consoantes.length())));
                } else {
                    senha.append(vogais.charAt(rand.nextInt(vogais.length())));
                }
            }

            if (tamanho % 2 != 0) {
                senha.setCharAt(tamanho-1, consoantes.charAt(rand.nextInt(consoantes.length())));
            }

            System.out.println("Senha gerada: " + senha);
        }
        sc.close();
    }
}
