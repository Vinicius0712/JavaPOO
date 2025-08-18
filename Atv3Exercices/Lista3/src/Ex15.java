public class Ex15 {
    public static void main(String[] args) {
        double s = 0;
        int numerador1 = 37, numerador2 = 38;

        for (int i = 1; i <= 37; i++) {
            s += (double) (numerador1 * numerador2) / i;
            numerador1--;
            numerador2--;
        }

        System.out.println("S = " + s);
    }
}
