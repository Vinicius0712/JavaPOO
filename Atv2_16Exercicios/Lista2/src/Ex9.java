import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite a temperatura em Fahrenheit: ");
        double f = in.nextDouble();
        double c = (f - 32) / 1.8;
        System.out.println("Celsius: " + c);
        in.close();
    }
}
