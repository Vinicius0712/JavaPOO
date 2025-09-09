public class ContaBancaria {
    private int numeroConta;
    private String nome;
    private double saldo;

    public ContaBancaria(int numeroConta, String nome, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public void alterarNome(String novoNome) {
        this.nome = novoNome;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saque inválido ou saldo insuficiente!");
        }
    }

    public void mostrarConta() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Nome: " + nome);
        System.out.println("Saldo: R$ " + saldo);
    }
}
