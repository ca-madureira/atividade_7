public class Trem implements IMeioTransporte {
    private int velocidade = 0;
    private final int VELOCIDADE_MAXIMA = 300;

    @Override
    public void acelerar() {
        if (velocidade + 50 > VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Trem não pode ultrapassar " + VELOCIDADE_MAXIMA + " km/h.");
        }
        velocidade += 50;
    }

    @Override
    public void frear() {
        if (velocidade - 50 < 0) {
            throw new IllegalStateException("Trem já está parado.");
        }
        velocidade -= 50;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Trem";
    }
}
