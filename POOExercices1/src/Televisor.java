public class Televisor {
    private int canal;
    private int volume;

    public Televisor() {
        this.canal = 1;
        this.volume = 10;
    }

    public void mudarCanal(int novoCanal) {
        if (novoCanal >= 1 && novoCanal <= 999) {
            canal = novoCanal;
        } else {
            System.out.println("Canal inválido!");
        }
    }

    public void aumentarVolume() {
        if (volume < 100) {
            volume++;
        } else {
            System.out.println("Volume máximo!");
        }
    }

    public void diminuirVolume() {
        if (volume > 0) {
            volume--;
        } else {
            System.out.println("Volume mínimo!");
        }
    }

    public void mostrarStatus() {
        System.out.println("Canal: " + canal);
        System.out.println("Volume: " + volume);
    }
}
