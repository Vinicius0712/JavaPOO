import java.util.Scanner;

public class TabuadaEx {
	public static void main(String[] args) {
		Scanner valor = new Scanner(System.in);
		
		System.out.println("Informe o valor do qual deseja a tabuada: ");
		int num1 = valor.nextInt();
		
		System.out.println("Informe o valor inicial à ser multiplicado: ");
		int inicio = valor.nextInt();
		
		System.out.println("Informe o valor final à ser multiplicado: ");
		int fim = valor.nextInt();
	
		if(inicio > fim){
			int iAux1 = inicio;
			inicio = fim;
			fim = iAux1;
			System.out.println("Devido à erro nas informações forneidas, os valores foram trocados!");
		}
		for(int iAux2 = inicio; iAux2 <= fim; iAux2++){
			System.out.println(num1+" x "+iAux2+" = "+(iAux2*num1));
		}
		valor.close();
	}
}
