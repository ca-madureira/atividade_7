public class Produto implements Identificavel<String> {
    private final String id;
    private final String nome;

    public Produto(String id, String nome) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("ID do produto não pode ser vazio.");
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Produto{id='" + id + "', nome='" + nome + "'}";
    }
}
