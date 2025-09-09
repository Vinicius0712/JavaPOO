import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n=== Exercício 2 ===");
        System.out.print("Digite o primeiro número: ");
        	int n1 = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        	int n2 = sc.nextInt();
        	
        Intervalo intervalo = new Intervalo(n1, n2);
        intervalo.mostrarIntervalo();

        sc.close();
    }
}
