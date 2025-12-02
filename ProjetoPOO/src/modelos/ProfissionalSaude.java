package modelos;

public class ProfissionalSaude {
    private String id; 
    private String nome;
    private String registro;

    public ProfissionalSaude(String id, String nome, String registro) {
        this.id = id;
        this.nome = nome;
        this.registro = registro;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getRegistro() { return registro; }

    public void setId(String id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setRegistro(String registro) { this.registro = registro; }

    @Override
    public String toString() {
        return id + " | " + nome + " | Reg.: " + registro;
    }

}
 