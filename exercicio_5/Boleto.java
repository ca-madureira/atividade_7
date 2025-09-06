import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBoleto;

    public Boleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void validarPagamento() {
        if (codigoBoleto == null || !codigoBoleto.matches("\\d{47}")) {
            throw new IllegalArgumentException("Código de boleto inválido. Deve conter 47 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " realizado via Boleto.");
    }
}
