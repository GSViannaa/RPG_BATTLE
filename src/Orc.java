public class Orc  extends  Monstros
{

    public Orc(String nome, short vida, short agilidade, String dano, short ataque, short defesa)
    {
        super("Orc", (short) 100, (short) 8, "2d6 + 3", (short) 15, (short) 8);
    }
    Dado dado;

    @Override
    public int iniciativa(short agilidade)
    {
        return Dado.rolarIniciativa() + agilidade;
    }

    @Override
    public int dano(short ataque)
    {
        return dado.rolarDano(ataque);
    }
}
