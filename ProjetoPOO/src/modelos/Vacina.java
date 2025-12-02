package modelos;

public class Vacina {
    private String id;
    private String nome;
    private String fabricante;
    private int totalDoses;
    private int intervaloDias;

    public Vacina(String nome, String fabricante, int totalDoses, int intervaloDias) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.totalDoses = totalDoses;
        this.intervaloDias = intervaloDias;
    }

    public Vacina(String id, String nome, String fabricante, int totalDoses, int intervaloDias) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.totalDoses = totalDoses;
        this.intervaloDias = intervaloDias;
    }

	public String getId() {return id; }
	public String getNome() { return nome; }
    public String getFabricante() { return fabricante; }
    public int getTotalDoses() { return totalDoses; }
    public int getIntervaloDias() { return intervaloDias; }

	public void setId(String id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public void setTotalDoses(int totalDoses) { this.totalDoses = totalDoses; }
    public void setIntervaloDias(int intervaloDias) { this.intervaloDias = intervaloDias; }

    @Override
    public String toString() {
        return nome + " | Fabricante: " + fabricante + " | Doses: " + totalDoses + " | Intervalo: " + intervaloDias + " dias";
    }


}
