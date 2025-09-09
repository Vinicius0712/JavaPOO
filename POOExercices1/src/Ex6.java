import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tamanho do lado do quadrado: ");
        double lado = sc.nextDouble();

        Quadrado q = new Quadrado(lado);

        System.out.println("Lado atual: " + q.getLado());
        System.out.println("Área: " + q.calcularArea());

        System.out.print("Digite um novo valor para o lado: ");
        double novoLado = sc.nextDouble();
        q.mudarLado(novoLado);

        System.out.println("Novo lado: " + q.getLado());
        System.out.println("Nova área: " + q.calcularArea());

        sc.close();
    }
}
