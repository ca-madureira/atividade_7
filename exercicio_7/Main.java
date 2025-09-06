import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        IRepository<Produto, String> repoProduto = new InMemoryRepository<>();
        IRepository<Funcionario, Integer> repoFuncionario = new InMemoryRepository<>();

        repoProduto.salvar(new Produto("P001", "Caneta"));
        repoProduto.salvar(new Produto("P002", "Caderno"));

        repoFuncionario.salvar(new Funcionario(1, "Camila"));
        repoFuncionario.salvar(new Funcionario(2, "Bruno"));

        System.out.println("Produtos:");
        repoProduto.listarTodos().forEach(System.out::println);

        System.out.println("\nFuncionários:");
        repoFuncionario.listarTodos().forEach(System.out::println);

        System.out.println("\nBuscando produto P002:");
        Optional<Produto> produto = repoProduto.buscarPorId("P002");
        produto.ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Produto não encontrado.")
        );

        System.out.println("\nRemovendo produto P001...");
        repoProduto.remover("P001");

        try {
            repoProduto.remover("P999"); // ID inexistente
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
