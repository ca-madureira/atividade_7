public class Main {
    public static void main(String[] args) {
        try {
            // Instância válida
            Produto p1 = new Produto("Caneta", 2.50, 100);
            System.out.println(p1);

            // Alterando valores válidos
            p1.setPreco(3.00);
            p1.setQuantidadeEmEstoque(120);
            System.out.println("Após alterações: " + p1);

            // Tentando atribuições inválidas
            p1.setPreco(-5.00); // Vai lançar exceção
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Produto p2 = new Produto("", 10.00, 50); // Nome inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }

        try {
            Produto p3 = new Produto("Lápis", -1.00, 30); // Preço inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }
    }
}
