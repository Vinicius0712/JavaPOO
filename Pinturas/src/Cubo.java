public class Cubo {
    public static final double[] PRECO_TIPO = {101.90, 212.45, 345.56};
    public static final double LITROS_POR_LATA = 18.0;

    private double lado;
    private double rendimento; // m² por litro
    private int tipoTinta;

    public Cubo() {
        this.lado = 1;
        this.rendimento = 1;
        this.tipoTinta = 1;
    }

    public Cubo(double lado, double rendimento) {
        this.lado = lado;
        this.rendimento = rendimento;
        this.tipoTinta = 1;
    }

    public Cubo(double lado, double rendimento, int tipoTinta) {
        this.lado = lado;
        this.rendimento = rendimento;
        this.tipoTinta = tipoTinta;
    }

    public double getLado() { return lado; }
    public void setLado(double lado) {
        if (lado > 0) this.lado = lado;
    }

    public double getRendimento() { return rendimento; }
    public void setRendimento(double rendimento) {
        if (rendimento > 0) this.rendimento = rendimento;
    }

    public int getTipoTinta() { return tipoTinta; }
    public void setTipoTinta(int tipoTinta) {
        if (tipoTinta >= 1 && tipoTinta <= 3) this.tipoTinta = tipoTinta;
    }

    public double getAreaBase() {
        return lado * lado;
    }

    public double getAreaTotal() {
        return 6 * getAreaBase();
    }

    public double getVolume() {
        return Math.pow(lado, 3);
    }

    public double getDiagonal() {
        return lado * Math.sqrt(3);
    }

    public double getLitrosNecessarios() {
        return getAreaTotal() / rendimento;
    }

    public int getQtdLatas() {
        return (int) Math.ceil(getLitrosNecessarios() / LITROS_POR_LATA);
    }

    public double getPrecoTotal() {
        return getQtdLatas() * PRECO_TIPO[tipoTinta - 1];
    }

    @Override
    public String toString() {
        return "\na : " + lado +
               "\nRendimento : " + rendimento +
               "\nTipo de Tinta : " + tipoTinta +
               "\n-----------------" +
               "\nÁrea da Base : " + getAreaBase() +
               "\nÁrea Total : " + getAreaTotal() +
               "\nVolume : " + getVolume() +
               "\nDiagonal do Cubo : " + getDiagonal() +
               "\nLitros de Tinta: " + getLitrosNecessarios() +
               "\nLatas de Tinta: " + getQtdLatas() +
               "\nValor Total: " + getPrecoTotal();
    }
}
