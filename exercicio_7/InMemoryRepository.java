import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {
    private final Map<ID, T> armazenamento = new HashMap<>();

    @Override
    public void salvar(T entidade) {
        armazenamento.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return List.copyOf(armazenamento.values()); // cópia imutável
    }

    @Override
    public void remover(ID id) {
        if (!armazenamento.containsKey(id)) {
            throw new IllegalArgumentException("ID não encontrado: " + id);
        }
        armazenamento.remove(id);
    }
}
