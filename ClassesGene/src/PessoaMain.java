
public class PessoaMain {

	public static void main(String[] args) {
	
		Pessoa p = new Pessoa("Vinicius", "Barragem");
		System.out.println(p);
		
		PessoaFisica pf = new PessoaFisica("Vinicius", "Barragem");
		pf.setCpf("1055410456");
		System.out.println(pf);
		
		PessoaJuridica pj = new PessoaJuridica("Vinicius", "Barragem");
		pj.setCnpj("105425410456");
		System.out.println(pf);		
		
	}

}
    