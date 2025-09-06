import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("06420000", new BigDecimal("150.00"), FretePadrao.SEDEX);
        System.out.println("Frete (Sedex): R$" + pedido.calcularFrete());

        pedido.setEstrategiaFrete(FretePadrao.PAC);
        System.out.println("Frete (PAC): R$" + pedido.calcularFrete());

        pedido.setEstrategiaFrete(FretePadrao.RETIRADA_LOJA);
        System.out.println("Frete (Retirada na loja): R$" + pedido.calcularFrete());

        pedido.setEstrategiaFrete(FretePadrao.promocaoFreteGratis(new BigDecimal("100")));
        System.out.println("Frete (Promoção acima de R$100): R$" + pedido.calcularFrete());

        try {
            Pedido pedidoInvalido = new Pedido("ABC123", new BigDecimal("50.00"), FretePadrao.PAC);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar pedido: " + e.getMessage());
        }
    }
}
