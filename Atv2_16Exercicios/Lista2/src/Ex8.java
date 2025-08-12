import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Quanto você ganha por hora? ");
        double valorHora = in.nextDouble();
        System.out.print("Quantas horas trabalha por mês? ");
        double horas = in.nextDouble();
        System.out.println("Salário: R$ " + (valorHora * horas));
        in.close();
    }
}
