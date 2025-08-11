import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner troca = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int num = troca.nextInt();

        if (num % 2 == 0) {
            num++;
            System.out.println("Era par, agora é ímpar: " + num);
        } else {
            num--;
            System.out.println("Era ímpar, agora é par: " + num);
        }

        troca.close();
    }
}
