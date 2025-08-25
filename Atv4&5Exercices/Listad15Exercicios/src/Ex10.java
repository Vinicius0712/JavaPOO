import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma data (dd/mm/aaaa): ");
        String data = sc.nextLine();

        String[] partes = data.split("/");
        if (partes.length != 3) {
            System.out.println("Data inválida!");
           sc.close();
           return;
        }

        int[] vetor = new int[3];
        vetor[0] = Integer.parseInt(partes[0]);
        vetor[1] = Integer.parseInt(partes[1]);
        vetor[2] = Integer.parseInt(partes[2]);

        if (vetor[0] < 1 || vetor[0] > 31 || vetor[1] < 1 || vetor[1] > 12) {
            System.out.println("Data inválida!");
        } else {
            System.out.println("Data armazenada no vetor: ");
            for (int v : vetor) System.out.print(v + " ");
        }
        sc.close();
    }
}
