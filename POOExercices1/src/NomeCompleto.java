public class NomeCompleto {
    private String nome;
    private String sobrenome;

    public NomeCompleto(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return "Seu nome completo é: " + nome + " " + sobrenome;
    }
}
