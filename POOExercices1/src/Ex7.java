import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Peso: ");
        double peso = sc.nextDouble();

        System.out.print("Altura (em cm): ");
        double altura = sc.nextDouble();

        Pessoa p = new Pessoa(nome, idade, peso, altura);

        p.envelhecer();
        p.engordar(2);
        p.emagrecer(1);
        p.crescer(3);

        System.out.println("\n--- Dados da Pessoa ---");
        System.out.println(p.getDados());

        sc.close();
    }
}
