package modelos;

public class DoseAplicada {

    private String id;
    private String data;
    private String unidadeId;
    private String profissionalId;
    private String lote;
    private int numeroDose;
    private String cpfPaciente;
    private String vacinaId;

    public DoseAplicada(String id, String data, String unidadeId, String profissionalId,
                        String lote, int numeroDose, String cpfPaciente, String vacinaId) {
        this.id = id;
        this.data = data;
        this.unidadeId = unidadeId;
        this.profissionalId = profissionalId;
        this.lote = lote;
        this.numeroDose = numeroDose;
        this.cpfPaciente = cpfPaciente;
        this.vacinaId = vacinaId;
    }

    public DoseAplicada(String data, String unidadeId, String profissionalId,
                        String lote, int numeroDose, String cpfPaciente, String vacinaId) {
        this(null, data, unidadeId, profissionalId, lote, numeroDose, cpfPaciente, vacinaId);
    }

    public String getId() { return id; }
    public String getData() { return data; }
    public String getUnidadeId() { return unidadeId; }
    public String getProfissionalId() { return profissionalId; }
    public String getLote() { return lote; }
    public int getNumeroDose() { return numeroDose; }
    public String getCpfPaciente() { return cpfPaciente; }
    public String getVacinaId() { return vacinaId; }

    public void setId(String id) { this.id = id; }
    public void setData(String data) { this.data = data; }
    public void setUnidadeId(String unidadeId) { this.unidadeId = unidadeId; }
    public void setProfissionalId(String profissionalId) { this.profissionalId = profissionalId; }
    public void setLote(String lote) { this.lote = lote; }
    public void setNumeroDose(int numeroDose) { this.numeroDose = numeroDose; }
    public void setCpfPaciente(String cpfPaciente) { this.cpfPaciente = cpfPaciente; }
    public void setVacinaId(String vacinaId) { this.vacinaId = vacinaId; }

    @Override
    public String toString() {
        return id + " | Paciente: " + cpfPaciente + " | Vacina: " + vacinaId +
                " | Dose: " + numeroDose + " | Data: " + data + " | Unidade: " + unidadeId +
                " | Profissional: " + profissionalId + " | Lote: " + lote;
    }
}
