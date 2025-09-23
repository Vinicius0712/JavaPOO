
public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private String TipoEmpresa;
	
	public PessoaJuridica(String nome,String endereco){
		super(nome, endereco);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if(cnpj.length() > 13)
		this.cnpj = cnpj;
	}
	
	
	public String getTipoEmpresa() {
		return TipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa){
		if(TipoEmpresa.length() > 1)
		TipoEmpresa = tipoEmpresa;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PessoaJuridica [cnpj=");
		builder.append(cnpj);
		builder.append(", TipoEmpresa=");
		builder.append(TipoEmpresa);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}


	
	
	
}
