import java.util.Scanner;

public class Ex21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma data no formato dd/mm/aaaa: ");
        String data = sc.nextLine();

        String[] partes = data.split("/");

        if (partes.length == 3) {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            boolean dataValida = true;

            if (mes < 1 || mes > 12 || dia < 1) {
                dataValida = false;
            } else {
                int[] diasMes = {31, (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0) ? 29 : 28,
                                 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (dia > diasMes[mes - 1]) {
                    dataValida = false;
                }
            }

            System.out.println(dataValida ? "Data válida" : "Data inválida");
        } else {
            System.out.println("Formato inválido.");
        }
        sc.close();
    }
}
