import java.util.Scanner;

public class Ex31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numAlunoAlto = 0, numAlunoBaixo = 0;
        int maiorAltura = 0, menorAltura = Integer.MAX_VALUE;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Número do aluno: ");
            int num = sc.nextInt();
            System.out.print("Altura em cm: ");
            int altura = sc.nextInt();

            if (altura > maiorAltura) {
                maiorAltura = altura;
                numAlunoAlto = num;
            }
            if (altura < menorAltura) {
                menorAltura = altura;
                numAlunoBaixo = num;
            }
        }

        System.out.println("Aluno mais alto: " + numAlunoAlto + " com " + maiorAltura + " cm");
        System.out.println("Aluno mais baixo: " + numAlunoBaixo + " com " + menorAltura + " cm");

        sc.close();
    }
}
