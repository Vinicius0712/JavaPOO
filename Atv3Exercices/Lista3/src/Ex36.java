import java.util.Scanner;

public class Ex36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c1=0, c2=0, c3=0, c4=0, nulo=0, branco=0;
        int voto;

        System.out.println("1 - José\n2 - João\n3 - Maria\n4 - Ana\n5 - Nulo\n6 - Branco");

        while (true) {
            System.out.print("Digite seu voto (0 para encerrar): ");
            voto = sc.nextInt();
            if (voto == 0) break;

            switch (voto) {
                case 1: c1++; break;
                case 2: c2++; break;
                case 3: c3++; break;
                case 4: c4++; break;
                case 5: nulo++; break;
                case 6: branco++; break;
                default: System.out.println("Voto inválido!");
            }
        }

        int total = c1+c2+c3+c4+nulo+branco;
        System.out.println("José: " + c1);
        System.out.println("João: " + c2);
        System.out.println("Maria: " + c3);
        System.out.println("Ana: " + c4);
        System.out.println("Nulos: " + nulo);
        System.out.println("Brancos: " + branco);
        if (total > 0) {
            System.out.println("% Nulos: " + (nulo*100.0/total) + "%");
            System.out.println("% Brancos: " + (branco*100.0/total) + "%");
        }

        sc.close();
    }
}
