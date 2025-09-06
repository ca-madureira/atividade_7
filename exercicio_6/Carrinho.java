import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Carrinho {
    private final List<ItemCarrinho> itens;

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(ItemCarrinho novoItem) {
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        novaLista.add(novoItem);
        return new Carrinho(novaLista);
    }

    public Carrinho removerItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        if (!novaLista.remove(item)) {
            throw new IllegalArgumentException("Item não encontrado no carrinho.");
        }
        return new Carrinho(novaLista);
    }

    public Carrinho aplicarCupom(BigDecimal percentualDesconto) {
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            Dinheiro precoComDesconto = item.getProduto().getPreco().aplicarDesconto(percentualDesconto);
            Produto produtoComDesconto = new Produto(item.getProduto().getNome(), precoComDesconto);
            novaLista.add(new ItemCarrinho(produtoComDesconto, item.getQuantidade()));
        }
        return new Carrinho(novaLista);
    }

    public Dinheiro calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        Moeda moeda = itens.isEmpty() ? Moeda.BRL : itens.get(0).getProduto().getPreco().getMoeda();
        for (ItemCarrinho item : itens) {
            total = total.add(item.getTotal().getValor());
        }
        return new Dinheiro(total, moeda);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrinho:\n");
        for (ItemCarrinho item : itens) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Total: ").append(calcularTotal());
        return sb.toString();
    }
}
