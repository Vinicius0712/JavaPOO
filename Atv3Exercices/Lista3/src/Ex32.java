import java.util.Scanner;

public class Ex32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int codMaior = 0, codMenor = 0;
        int maiorAcid = 0, menorAcid = Integer.MAX_VALUE;
        int somaVeiculos = 0, somaAcidMenos2000 = 0, contMenos2000 = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Código da cidade: ");
            int cod = sc.nextInt();
            System.out.print("Número de veículos: ");
            int veiculos = sc.nextInt();
            System.out.print("Número de acidentes: ");
            int acidentes = sc.nextInt();

            somaVeiculos += veiculos;

            if (acidentes > maiorAcid) {
                maiorAcid = acidentes;
                codMaior = cod;
            }
            if (acidentes < menorAcid) {
                menorAcid = acidentes;
                codMenor = cod;
            }
            if (veiculos < 2000) {
                somaAcidMenos2000 += acidentes;
                contMenos2000++;
            }
        }

        System.out.println("Maior índice de acidentes: Cidade " + codMaior + " com " + maiorAcid);
        System.out.println("Menor índice de acidentes: Cidade " + codMenor + " com " + menorAcid);
        System.out.println("Média de veículos: " + (somaVeiculos / 5.0));
        if (contMenos2000 > 0) {
            System.out.println("Média de acidentes em cidades <2000 veículos: " + (somaAcidMenos2000 / (double) contMenos2000));
        }

        sc.close();
    }
}
