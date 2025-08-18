import java.util.Scanner;

public class Ex28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double soma = 0, maior = Double.MIN_VALUE, menor = Double.MAX_VALUE;
        int cont = 0;

        while (true) {
            System.out.print("Temperatura (999 para parar): ");
            double temp = sc.nextDouble();
            if (temp == 999) break;
            soma += temp;
            cont++;
            if (temp > maior) maior = temp;
            if (temp < menor) menor = temp;
        }

        System.out.println("Menor: " + menor);
        System.out.println("Maior: " + maior);
        System.out.println("Média: " + (soma / cont));
        sc.close();
    }
}
