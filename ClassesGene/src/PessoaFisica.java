
public class PessoaFisica extends Pessoa {
	
	private String cpf;
	private String EstadoCivil;
	
	public PessoaFisica(String nome,String endereco){
		super(nome, endereco);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.length() > 10)
		this.cpf = cpf;
	}

	public String getEstadoCivil() {
		return EstadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		if (EstadoCivil.length() > 1)
		EstadoCivil = estadoCivil;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PessoaFisica [cpf=");
		builder.append(cpf);
		builder.append(", EstadoCivil=");
		builder.append(EstadoCivil);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}


	
	

}
