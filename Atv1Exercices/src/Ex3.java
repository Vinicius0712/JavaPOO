import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner Sexo = new Scanner(System.in);

        System.out.print("Digite F para Feminino ou M para Masculino: ");
        String letra = Sexo.nextLine().toUpperCase();

        if (letra.equals("F")) {
            System.out.println("F - Feminino");
        } else if (letra.equals("M")) {
            System.out.println("M - Masculino");
        } else {
            System.out.println("Letra inválida!");
        }

        Sexo.close();
    }
}
