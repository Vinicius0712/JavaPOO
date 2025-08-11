import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner verifica_origem = new Scanner(System.in);

        System.out.print("Digite o preço de custo: ");
        double preco = verifica_origem.nextDouble();

        System.out.print("Digite o código de origem: ");
        int codigo = verifica_origem.nextInt();

        String origem;
        switch (codigo) {
            case 1: origem = "Sul"; break;
            case 2: origem = "Norte"; break;
            case 3: origem = "Leste"; break;
            case 4: origem = "Oeste"; break;
            case 5: case 6: origem = "Nordeste"; break;
            case 7: case 8: origem = "Centro-Oeste"; break;
            default: origem = "Importado";
        }

        System.out.println("Preço: R$ " + preco + " - Origem: " + origem);

        verifica_origem.close();
    }
}
