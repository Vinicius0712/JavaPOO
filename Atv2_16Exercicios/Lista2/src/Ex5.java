import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o valor em metros: ");
        double metros = in.nextDouble();
        System.out.println("Centímetros: " + (metros * 100));
        in.close();
    }
}
