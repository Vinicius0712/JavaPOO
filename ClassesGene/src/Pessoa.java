
public class Pessoa {
	private String nome;
	private String Endereco;

	public String getNome() {
		return nome;
	}

	public Pessoa(String nome, String endereco) {
	}

	public void setNome(String nome) {
		if (nome.length() > 3)
		this.nome = nome;	
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		if (Endereco.length() > 3)
		Endereco = endereco;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", Endereco=");
		builder.append(Endereco);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	

	
	
}
