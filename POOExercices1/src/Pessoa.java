public class Pessoa {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Pessoa(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public void envelhecer() {
        idade++;
        if (idade < 21) {
            altura += 0.5;
        }
    }

    public void engordar(double kg) {
        peso += kg;
    }

    public void emagrecer(double kg) {
        peso -= kg;
    }

    public void crescer(double cm) {
        altura += cm;
    }

    public String getDados() {
        return "Nome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso + "kg\nAltura: " + altura + "cm";
    }
}
