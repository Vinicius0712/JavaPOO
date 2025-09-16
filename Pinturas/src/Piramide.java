public class Piramide {
    public static final double[] PRECO_TIPO = {127.90, 258.98, 344.34};
    public static final double RENDIMENTO = 4.76; // m² por litro
    public static final double LITROS_POR_LATA = 18.0;

    private double ab;       // lado da base
    private double h;        // altura
    private int tipoTinta;

    public Piramide() {
        this.ab = 1;
        this.h = 1;
        this.tipoTinta = 1;
    }

    public Piramide(double ab, double h) {
        this.ab = ab;
        this.h = h;
        this.tipoTinta = 1;
    }

    public Piramide(double ab, double h, int tipoTinta) {
        this.ab = ab;
        this.h = h;
        this.tipoTinta = tipoTinta;
    }

    public double getAb() { return ab; }
    public void setAb(double ab) { if (ab > 0) this.ab = ab; }

    public double getH() { return h; }
    public void setH(double h) { if (h > 0) this.h = h; }

    public int getTipoTinta() { return tipoTinta; }
    public void setTipoTinta(int tipoTinta) {
        if (tipoTinta >= 1 && tipoTinta <= 3) this.tipoTinta = tipoTinta;
    }

    public double getA1() {
        return Math.sqrt(Math.pow(ab / 2.0, 2) + Math.pow(h, 2));
    }

    public double getAreaTriangulo() {
        return (ab * getA1()) / 2.0;
    }

    public double getAreaBase() {
        return ab * ab;
    }

    public double getAreaTotal() {
        return 4 * getAreaTriangulo() + getAreaBase();
    }

    public double getLitros() {
        return getAreaTotal() / RENDIMENTO;
    }

    public int getQtdLatas() {
        return (int) Math.ceil(getLitros() / LITROS_POR_LATA);
    }

    public double getPreco() {
        return getQtdLatas() * PRECO_TIPO[tipoTinta - 1];
    }

    public double getVolume() {
        return (getAreaBase() * h) / 3.0;
    }
    @Override
    public String toString() {
        return "\nab: " + ab +
               "\nh: " + h +
               "\na1: " + getA1() +
               "\nÁrea Triângulo: " + getAreaTriangulo() +
               "\nÁrea Base: " + getAreaBase() +
               "\nÁrea Total: " + getAreaTotal() +
               "\nTipo de Tinta: " + tipoTinta +
               "\nLitros: " + getLitros() +
               "\nLatas: " + getQtdLatas() +
               "\nPreço: " + getPreco() +
               "\nVolume: " + getVolume();
    }
}
