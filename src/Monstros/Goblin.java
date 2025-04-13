package Monstros;

import Sistema.Dado;
import Entidades.Monstros;

public class Goblin  extends Monstros
{
    public Goblin()
    {
        super("Entidades.Monstros.Goblin", (short) 85, (short) 12, "2d6 + 3", (short) 15, (short) 5);
    }
    Dado dado;

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() + agilidade;
    }

    @Override
    public int dano(short ataqueMaximo)
    {
        return dado.rolarDano(ataqueMaximo);
    }
}
