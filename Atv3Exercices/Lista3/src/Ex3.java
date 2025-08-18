import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome;
        int idade;
        double salario;
        char sexo, estadoCivil;

        do {
            System.out.print("Nome (mais de 3 caracteres): ");
            nome = sc.nextLine();
        } while (nome.length() <= 3);

        do {
            System.out.print("Idade (0 a 150): ");
            idade = sc.nextInt();
        } while (idade < 0 || idade > 150);

        do {
            System.out.print("Salário (>0): ");
            salario = sc.nextDouble();
        } while (salario <= 0);

        do {
            System.out.print("Sexo (f/m): ");
            sexo = sc.next().charAt(0);
        } while (sexo != 'f' && sexo != 'm');

        do {
            System.out.print("Estado Civil (s/c/v/d): ");
            estadoCivil = sc.next().charAt(0);
        } while (estadoCivil != 's' && estadoCivil != 'c' && estadoCivil != 'v' && estadoCivil != 'd');

        System.out.println("Cadastro válido!");
        sc.close();
    }
}
