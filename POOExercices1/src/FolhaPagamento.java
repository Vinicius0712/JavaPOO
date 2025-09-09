public class FolhaPagamento {
    private double salarioHora;
    private int horasTrabalhadas;

    public FolhaPagamento(double salarioHora, int horasTrabalhadas) {
        this.salarioHora = salarioHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double calcularSalarioBruto() {
        return salarioHora * horasTrabalhadas;
    }

    public double calcularIR() {
        return calcularSalarioBruto() * 0.11;
    }

    public double calcularINSS() {
        return calcularSalarioBruto() * 0.08;
    }

    public double calcularSindicato() {
        return calcularSalarioBruto() * 0.05;
    }

    public double calcularSalarioLiquido() {
        return calcularSalarioBruto() - (calcularIR() + calcularINSS() + calcularSindicato());
    }

    public void mostrarResumo() {
        System.out.printf("+ Salário Bruto : R$ %.2f\n", calcularSalarioBruto());
        System.out.printf("- IR (11%%) : R$ %.2f\n", calcularIR());
        System.out.printf("- INSS (8%%) : R$ %.2f\n", calcularINSS());
        System.out.printf("- Sindicato (5%%) : R$ %.2f\n", calcularSindicato());
        System.out.printf("= Salário Líquido : R$ %.2f\n", calcularSalarioLiquido());
    }
}
