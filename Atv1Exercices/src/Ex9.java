import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner ideal = new Scanner(System.in);

        System.out.print("Digite sua altura (em metros): ");
        double altura = ideal.nextDouble();

        System.out.print("Digite seu peso (em kg): ");
        double peso = ideal.nextDouble();

        System.out.print("Digite seu sexo (M/F): ");
        String sexo = ideal.next().toUpperCase();

        double pesoIdeal;

        if (sexo.equals("M")) {
            pesoIdeal = (72.7 * altura) - 58;
        } else if (sexo.equals("F")) {
            pesoIdeal = (62.1 * altura) - 44.7;
        } else {
            System.out.println("Sexo inválido.");
            ideal.close();
            return;
        }

        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Sexo: " + sexo);
        System.out.println("Peso ideal: " + pesoIdeal);

        if (peso > pesoIdeal) {
            System.out.println("Você está acima do peso ideal.");
        } else if (peso < pesoIdeal) {
            System.out.println("Você está abaixo do peso ideal.");
        } else {
            System.out.println("Você está no peso ideal.");
        }

        ideal.close();
    }
}
