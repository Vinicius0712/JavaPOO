package modelos;

public class Paciente {

    private String cpf;
    private String nome;
    private String sexo;
    private int idade; // pode permanecer int
    private String dataNascimento; // formato YYYY-MM-DD

    // Construtor principal (usado para inserir)
    public Paciente(String nome, String sexo, int idade, String cpf, String dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Construtor usado pelo DAO ao listar/buscar
    public Paciente(String cpf, String nome, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Getters
    public String getNome() { return nome; }
    public String getSexo() { return sexo; }
    public int getIdade() { return idade; }
    public String getCpf() { return cpf; }
    public String getDataNascimento() { return dataNascimento; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    @Override
    public String toString() {
        return nome + " | CPF: " + cpf + " | Idade: " + idade + " | Nasc: " + dataNascimento;
    }
}
