import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Exercício 4 ===");
        System.out.print("Quanto você ganha por hora? ");
        	double salarioHora = sc.nextDouble();
        System.out.print("Quantas horas trabalhou no mês? ");
        	int horas = sc.nextInt();
        	
        FolhaPagamento fp = new FolhaPagamento(salarioHora, horas);
        fp.mostrarResumo();
        
        sc.close();
    }
}
