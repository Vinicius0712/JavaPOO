import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int anos = 0;
        double populacaoA = 80000;
        double populacaoB = 200000;

        while (populacaoA < populacaoB) {
            populacaoA *= 1.03;
            populacaoB *= 1.015;
            anos++;
        }

        System.out.println("População A ultrapassa B em " + anos + " anos.");
        sc.close();
    }
}
