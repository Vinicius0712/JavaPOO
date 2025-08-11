import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner sal = new Scanner(System.in);

        System.out.print("Digite o salário atual: ");
        double salario = sal.nextDouble();
        double percentual = 0;

        if (salario <= 280) {
            percentual = 20;
        } else if (salario <= 700) {
            percentual = 15;
        } else if (salario <= 1500) {
            percentual = 10;
        } else {
            percentual = 5;
        }

        double aumento = salario * (percentual / 100);
        double novoSalario = salario + aumento;

        System.out.println("Salário antes do reajuste: R$ " + salario);
        System.out.println("Percentual de aumento: " + percentual + "%");
        System.out.println("Valor do aumento: R$ " + aumento);
        System.out.println("Novo salário: R$ " + novoSalario);

        sal.close();
    }
}