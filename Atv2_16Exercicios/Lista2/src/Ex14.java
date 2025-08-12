import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Quanto você ganha por hora? ");
        double valorHora = in.nextDouble();
        System.out.print("Quantas horas trabalha por mês? ");
        double horas = in.nextDouble();

        double salarioBruto = valorHora * horas;
        double ir = salarioBruto * 0.11;
        double inss = salarioBruto * 0.08;
        double sindicato = salarioBruto * 0.05;
        double salarioLiquido = salarioBruto - ir - inss - sindicato;

        System.out.println("Salário Bruto: R$ " + salarioBruto);
        System.out.println("IR: R$ " + ir);
        System.out.println("INSS: R$ " + inss);
        System.out.println("Sindicato: R$ " + sindicato);
        System.out.println("Salário Líquido: R$ " + salarioLiquido);
        in.close();
    }
}
