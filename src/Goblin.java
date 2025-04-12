public class Goblin  extends  Monstros
{
    public Goblin(String nome, short vida, short agilidade, String dano, short ataque, short defesa)
    {
        super("Goblin", (short) 85, (short) 12, "2d6 + 3", (short) 15, (short) 5);
    }
    Dado dado;

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
