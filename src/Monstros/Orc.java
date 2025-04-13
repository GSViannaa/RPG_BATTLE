package Monstros;

import Sistema.Dado;
import Entidades.Monstros;

public class Orc  extends Monstros
{

    public Orc()
    {
        super("Entidades.Monstros.Orc", (short) 100, (short) 8, "2d6 + 3", (short) 15, (short) 8);
    }
    Dado dado;

    @Override
    public int iniciativa(short agilidade)
    {
        return Dado.rolarIniciativa() + agilidade;
    }

    @Override
    public int dano(short ataqueMaximo)
    {
        return dado.rolarDano(ataqueMaximo);
    }
}
