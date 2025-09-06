public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("Quantidade em estoque inválida");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("Quantidade em estoque inválida");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

   
}
