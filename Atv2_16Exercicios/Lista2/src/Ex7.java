import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o lado do quadrado: ");
        double lado = in.nextDouble();
        double area = lado * lado;
        System.out.println("Área: " + area);
        in.close();
    }
}
