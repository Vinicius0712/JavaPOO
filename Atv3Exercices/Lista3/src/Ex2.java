import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String usuario, senha;
        do {
            System.out.print("Digite o nome de usuário: ");
            usuario = sc.nextLine();
            System.out.print("Digite a senha: ");
            senha = sc.nextLine();
            if (usuario.equals(senha)) {
                System.out.println("Erro: a senha não pode ser igual ao nome de usuário.");
            }
        } while (usuario.equals(senha));
        System.out.println("Cadastro válido!");
        sc.close();
    }
}
