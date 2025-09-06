import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FormaPagamento> pagamentos = new ArrayList<>();

        pagamentos.add(new CartaoCredito("1234567812345678")); // válido
        pagamentos.add(new Boleto("12345678901234567890123456789012345678901234567")); // válido
        pagamentos.add(new Pix("camila@email.com")); // válido
        pagamentos.add(new CartaoCredito("123")); // inválido

        for (FormaPagamento forma : pagamentos) {
            try {
                forma.processarPagamento(new BigDecimal("150.00"));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao processar pagamento: " + e.getMessage());
            }
        }
    }
}
