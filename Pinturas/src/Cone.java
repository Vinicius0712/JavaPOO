public class Cone {
    public static final double PI = 3.14;
    public static final double RENDIMENTO = 3.45; // m² por litro
    public static final double LITROS_POR_LATA = 18.0;
    public static final double[] PRECO_TIPO = {238.90, 467.98, 758.34};

    private double raio;
    private double altura;
    private int tipoTinta;

    public Cone() {
        this.raio = 0;
        this.altura = 0;
        this.tipoTinta = 1;
    }

    public Cone(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
        this.tipoTinta = 1;
    }

    public Cone(double raio, double altura, int tipoTinta) {
        this.raio = raio;
        this.altura = altura;
        this.tipoTinta = tipoTinta;
    }

    public double getRaio() { return raio; }
    public void setRaio(double raio) { this.raio = raio; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public int getTipoTinta() { return tipoTinta; }
    public void setTipoTinta(int tipoTinta) { this.tipoTinta = tipoTinta; }

    public double getGeratriz() {
        return Math.sqrt(Math.pow(raio, 2) + Math.pow(altura, 2));
    }

    public double getAreaFundo() {
        return PI * Math.pow(raio, 2);
    }

    public double getAreaLateral() {
        return PI * raio * getGeratriz();
    }

    public double getAreaTotal() {
        return getAreaFundo() + getAreaLateral();
    }

    public double getLitrosNecessarios() {
        return getAreaTotal() / RENDIMENTO;
    }

    public int getQtdLatas() {
        return (int) Math.ceil(getLitrosNecessarios() / LITROS_POR_LATA);
    }

    public double getPrecoTotal() {
        return getQtdLatas() * PRECO_TIPO[tipoTinta - 1];
    }
    @Override
    public String toString() {
        return "\n--- Cone ---" +
               "\nRaio: " + raio +
               "\nAltura: " + altura +
               "\nNível: " + tipoTinta +
               "\n----------------------" +
               "\nGeratriz: " + getGeratriz() +
               "\n----------------------" +
               "\nÁrea do Fundo: " + getAreaFundo() +
               "\nÁrea Lateral Cone: " + getAreaLateral() +
               "\nÁrea Total: " + getAreaTotal() +
               "\n----------------------" +
               "\nLitros: " + getLitrosNecessarios() +
               "\nLatas: " + getQtdLatas() +
               "\n----------------------" +
               "\nPreço Total: " + getPrecoTotal();
    }
}
