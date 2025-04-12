public class Morto_Vivo extends Monstros
{

    public Morto_Vivo(String nome, short vida, short agilidade, String dano, short ataque, short defesa) {
        super("Morto-Vivo", (short) 80, (short) 10, "1d6 + 3", (short) 9, (short) 3);
    }

    Dado dado = new Dado();

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() + agilidade;
    }

    @Override
    public int dano(short ataque)
    {
        return dado.rolarDano(ataque);
    }
}
