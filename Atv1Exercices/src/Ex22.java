import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro menor que 1000: ");
        int num = sc.nextInt();

        if (num < 0 || num >= 1000) {
            System.out.println("Número inválido.");
        } else {
            int centenas = num / 100;
            int dezenas = (num % 100) / 10;
            int unidades = num % 10;

            System.out.println(num + " = " +
                    (centenas > 0 ? centenas + " centena" + (centenas > 1 ? "s" : "") : "") +
                    (dezenas > 0 ? (centenas > 0 ? ", " : "") + dezenas + " dezena" + (dezenas > 1 ? "s" : "") : "") +
                    (unidades > 0 ? ((centenas > 0 || dezenas > 0) ? " e " : "") + unidades + " unidade" + (unidades > 1 ? "s" : "") : ""));
        }
        sc.close();
    }
}
