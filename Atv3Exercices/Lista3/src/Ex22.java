import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de votantes: ");
        int n = sc.nextInt();

        int c1=0, c2=0, c3=0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Vote (1, 2 ou 3): ");
            int voto = sc.nextInt();
            if (voto == 1) c1++;
            else if (voto == 2) c2++;
            else if (voto == 3) c3++;
        }

        System.out.println("Candidato 1: " + c1 + " votos");
        System.out.println("Candidato 2: " + c2 + " votos");
        System.out.println("Candidato 3: " + c3 + " votos");
        sc.close();
    }
}
