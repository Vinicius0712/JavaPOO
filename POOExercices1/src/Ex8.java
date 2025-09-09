import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Nome do titular: ");
        String nome = sc.nextLine();

        System.out.print("Saldo inicial: R$ ");
        double saldo = sc.nextDouble();

        ContaBancaria conta = new ContaBancaria(numero, nome, saldo);

        int opcao;
        do {
            System.out.println("\n1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Alterar nome");
            System.out.println("4 - Mostrar conta");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: R$ ");
                    double dep = sc.nextDouble();
                    conta.depositar(dep);
                    break;
                case 2:
                    System.out.print("Valor do saque: R$ ");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    conta.alterarNome(novoNome);
                    break;
                case 4:
                    conta.mostrarConta();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
