import java.util.Scanner;

public class Ex29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] perguntas = {
            "Telefonou para a vítima?",
            "Esteve no local do crime?",
            "Mora perto da vítima?",
            "Devia para a vítima?",
            "Já trabalhou com a vítima?"
        };

        int contSim = 0;
        for (String pergunta : perguntas) {
            System.out.print(pergunta + " (s/n): ");
            char resp = sc.next().toLowerCase().charAt(0);
            if (resp == 's') contSim++;
        }

        if (contSim == 2) {
            System.out.println("Suspeita");
        } else if (contSim >= 3 && contSim <= 4) {
            System.out.println("Cúmplice");
        } else if (contSim == 5) {
            System.out.println("Assassino");
        } else {
            System.out.println("Inocente");
        }
        sc.close();
    }
}
