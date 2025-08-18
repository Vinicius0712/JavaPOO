public class Ex5 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i); // um embaixo do outro
        }
        System.out.println("\nAgora um ao lado do outro:");
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + " ");
        }
    }
}
