public class Bicicleta implements IMeioTransporte {
    private int velocidade = 0;
    private final int VELOCIDADE_MAXIMA = 40;

    @Override
    public void acelerar() {
        if (velocidade + 5 > VELOCIDADE_MAXIMA) {
            throw new IllegalStateException("Bicicleta não pode ultrapassar " + VELOCIDADE_MAXIMA + " km/h.");
        }
        velocidade += 5;
    }

    @Override
    public void frear() {
        if (velocidade - 5 < 0) {
            throw new IllegalStateException("Bicicleta já está parada.");
        }
        velocidade -= 5;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Bicicleta";
    }
}
