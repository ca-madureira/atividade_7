public class Carro implements IMeioTransporte {
    private int velocidade = 0;
    private final int VELOCIDADE_MAXIMA = 180;

    @Override
    public void acelerar() {
        if (velocidade + 20 > VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Carro não pode ultrapassar " + VELOCIDADE_MAXIMA + " km/h.");
        }
        velocidade += 20;
    }

    @Override
    public void frear() {
        if (velocidade - 20 < 0) {
            throw new IllegalStateException("Carro já está parado.");
        }
        velocidade -= 20;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Carro";
    }
}
