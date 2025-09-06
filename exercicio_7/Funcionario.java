public class Funcionario implements Identificavel<Integer> {
    private final Integer id;
    private final String nome;

    public Funcionario(Integer id, String nome) {
        if (id == null || id <= 0) throw new IllegalArgumentException("ID do funcionário deve ser positivo.");
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome do funcionário não pode ser vazio.");
        this.id = id;
        this.nome = nome;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Funcionario{id=" + id + ", nome='" + nome + "'}";
    }
}
