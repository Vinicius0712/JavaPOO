import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner pag = new Scanner(System.in);

        System.out.print("Digite o valor da hora: ");
        double valorHora = pag.nextDouble();

        System.out.print("Digite a quantidade de horas trabalhadas no mês: ");
        double horas = pag.nextDouble();

        double salarioBruto = valorHora * horas;
        double ir = 0;

        if (salarioBruto <= 900) {
            ir = 0;
        } else if (salarioBruto <= 1500) {
            ir = salarioBruto * 0.05;
        } else if (salarioBruto <= 2500) {
            ir = salarioBruto * 0.10;
        } else {
            ir = salarioBruto * 0.20;
        }

        double inss = salarioBruto * 0.10;
        double fgts = salarioBruto * 0.11;
        double totalDescontos = ir + inss;
        double salarioLiquido = salarioBruto - totalDescontos;

        System.out.println("Salário Bruto: R$ " + salarioBruto);
        System.out.println("(-) IR: R$ " + ir);
        System.out.println("(-) INSS (10%): R$ " + inss);
        System.out.println("FGTS (11%): R$ " + fgts);
        System.out.println("Total de descontos: R$ " + totalDescontos);
        System.out.println("Salário Líquido: R$ " + salarioLiquido);

        pag.close();
    }
}
