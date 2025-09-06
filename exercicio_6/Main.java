import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Produto caneta = new Produto("Caneta", new Dinheiro(new BigDecimal("2.50"), Moeda.BRL));
        Produto caderno = new Produto("Caderno", new Dinheiro(new BigDecimal("15.00"), Moeda.BRL));

        Carrinho carrinho = new Carrinho(List.of());
        carrinho = carrinho.adicionarItem(new ItemCarrinho(caneta, 3));
        carrinho = carrinho.adicionarItem(new ItemCarrinho(caderno, 2));

        System.out.println("Carrinho original:");
        System.out.println(carrinho);

        Carrinho comDesconto = carrinho.aplicarCupom(new BigDecimal("20"));
        System.out.println("\nCarrinho com 20% de desconto:");
        System.out.println(comDesconto);

        try {
            carrinho.aplicarCupom(new BigDecimal("50")); // inválido
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro ao aplicar cupom: " + e.getMessage());
        }
    }
}
