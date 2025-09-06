import java.math.BigDecimal;

public class Pedido {
    private final String cepDestino;
    private final BigDecimal valorTotal;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorTotal, CalculadoraFrete estrategiaFrete) {
        if (!cepDestino.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos.");
        }
        if (valorTotal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor total não pode ser negativo.");
        }
        this.cepDestino = cepDestino;
        this.valorTotal = valorTotal;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setEstrategiaFrete(CalculadoraFrete novaEstrategia) {
        this.estrategiaFrete = novaEstrategia;
    }

    public BigDecimal calcularFrete() {
        return estrategiaFrete.calcular(this);
    }
}
