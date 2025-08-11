import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner periodo = new Scanner(System.in);

        System.out.print("Digite M para Matutino, V para Vespertino ou N para Noturno: ");
        String turno = periodo.nextLine().toUpperCase();

        if (turno.equals("M")) {
            System.out.println("Bom Dia!");
        } else if (turno.equals("V")) {
            System.out.println("Boa Tarde!");
        } else if (turno.equals("N")) {
            System.out.println("Boa Noite!");
        } else {
            System.out.println("Valor inválido!");
        }

        periodo.close();
    }
}
