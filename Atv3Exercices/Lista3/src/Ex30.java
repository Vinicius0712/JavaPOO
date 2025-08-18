import java.util.Scanner;

public class Ex30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int codMaisAlto=0, codMaisBaixo=0, codMaisGordo=0, codMaisMagro=0;
        double maiorAltura=0, menorAltura=Double.MAX_VALUE;
        double maiorPeso=0, menorPeso=Double.MAX_VALUE;
        double somaAltura=0, somaPeso=0;
        int cont=0;

        while (true) {
            System.out.print("Código (0 para parar): ");
            int cod = sc.nextInt();
            if (cod == 0) break;

            System.out.print("Altura: ");
            double alt = sc.nextDouble();
            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            if (alt > maiorAltura) { maiorAltura = alt; codMaisAlto = cod; }
            if (alt < menorAltura) { menorAltura = alt; codMaisBaixo = cod; }
            if (peso > maiorPeso) { maiorPeso = peso; codMaisGordo = cod; }
            if (peso < menorPeso) { menorPeso = peso; codMaisMagro = cod; }

            somaAltura += alt;
            somaPeso += peso;
            cont++;
        }

        System.out.println("Mais alto: " + codMaisAlto + " (" + maiorAltura + ")");
        System.out.println("Mais baixo: " + codMaisBaixo + " (" + menorAltura + ")");
        System.out.println("Mais gordo: " + codMaisGordo + " (" + maiorPeso + ")");
        System.out.println("Mais magro: " + codMaisMagro + " (" + menorPeso + ")");
        System.out.println("Média alturas: " + (somaAltura/cont));
        System.out.println("Média pesos: " + (somaPeso/cont));
        sc.close();
    }
}
