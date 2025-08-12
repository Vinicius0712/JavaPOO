import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o raio do círculo: ");
        double raio = in.nextDouble();
        double area = Math.PI * Math.pow(raio, 2);
        System.out.println("Área: " + area);
        in.close();
    }
}
