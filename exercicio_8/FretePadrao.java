import java.math.BigDecimal;

public class FretePadrao {
    public static final CalculadoraFrete SEDEX = pedido -> {
        validarCep(pedido.getCepDestino());
        return new BigDecimal("30.00");
    };

    public static final CalculadoraFrete PAC = pedido -> {
        validarCep(pedido.getCepDestino());
        return new BigDecimal("20.00");
    };

    public static final CalculadoraFrete RETIRADA_LOJA = pedido -> BigDecimal.ZERO;

    public static CalculadoraFrete promocaoFreteGratis(BigDecimal minimo) {
        return pedido -> {
            validarCep(pedido.getCepDestino());
            return pedido.getValorTotal().compareTo(minimo) >= 0
                ? BigDecimal.ZERO
                : new BigDecimal("25.00");
        };
    }

    private static void validarCep(String cep) {
        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos.");
        }
        
    }
}
