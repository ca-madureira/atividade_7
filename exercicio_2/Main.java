public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Caderno", 20.00, 50);
        System.out.println("Preço original: " + p1);

        try {
            p1.aplicarDesconto(30); // válido
            System.out.println("Após 30% de desconto: " + p1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }

        try {
            p1.aplicarDesconto(70); // inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }

        try {
            p1.aplicarDesconto(-10); // inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }
    }
}
