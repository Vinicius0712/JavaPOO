
import java.util.Scanner;

	public class Ex1 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Digite seu nome: ");
				String nome = sc.nextLine();
			System.out.print("Digite seu sobrenome: ");
				String sobrenome = sc.nextLine();
				
        NomeCompleto nc = new NomeCompleto(nome, sobrenome);
        System.out.println(nc.getNomeCompleto());

        sc.close();
	}

}
