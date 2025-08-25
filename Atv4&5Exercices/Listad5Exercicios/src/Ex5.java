import java.io.*;
import java.util.*;

public class Ex5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int[] sorteio = gerarCartela(rand);
        System.out.println("Números sorteados: " + Arrays.toString(sorteio));

        System.out.print("Quantas cartelas deseja gerar? ");
        int n = sc.nextInt();

        PrintWriter out = new PrintWriter(new FileWriter("loteria.txt"));
        out.println("Sorteio: " + Arrays.toString(sorteio));

        for (int i = 0; i < n; i++) {
            int[] cartela = gerarCartela(rand);
            int acertos = contarAcertos(cartela, sorteio);
            out.println("Cartela " + (i+1) + ": " + Arrays.toString(cartela) + " - Acertos: " + acertos);
        }
        out.close();

        System.out.println("\n--- RESULTADOS ---");
        Scanner arq = new Scanner(new File("loteria.txt"));
        while (arq.hasNextLine()) {
            System.out.println(arq.nextLine());
        }
        arq.close();
        sc.close();
    }

    public static int[] gerarCartela(Random rand) {
        Set<Integer> numeros = new TreeSet<>();
        while (numeros.size() < 6) {
            numeros.add(rand.nextInt(60) + 1);
        }
        return numeros.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int contarAcertos(int[] cartela, int[] sorteio) {
        int acertos = 0;
        for (int num : cartela) {
            for (int s : sorteio) {
                if (num == s) acertos++;
            }
        }
        return acertos;
    }
}
