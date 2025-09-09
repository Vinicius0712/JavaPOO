public class Intervalo {
    private int inicio;
    private int fim;

    public Intervalo(int inicio, int fim) {
        if (inicio > fim) {
            System.out.println("Valores invertidos! O programa irá corrigir.");
            this.inicio = fim;
            this.fim = inicio;
        } else {
            this.inicio = inicio;
            this.fim = fim;
        }
    }

    public void mostrarIntervalo() {
        System.out.println("Números no intervalo:");
        for (int i = inicio; i <= fim; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
