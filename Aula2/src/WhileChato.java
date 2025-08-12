import java.util.Scanner;

public class WhileChato {
	public static void main(String[] args) {
		
		int valor;
		Scanner par = new Scanner(System.in);
		
		do {
			System.out.print("Informe um valor par: ");
			valor = par.nextInt();
			
			if (valor % 2 != 0){
				System.out.println("O valor informado necessita ser par!");	
			}
			
		} while(valor % 2 != 0);
		System.out.println("O valor informado É par!");	
		
		par.close();
	}
}
    