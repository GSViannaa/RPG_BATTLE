package Monstros;

import Sistema.Dado;
import Entidades.Monstros;

public class Morto_Vivo extends Monstros
{

    public Morto_Vivo() {
        super("Morto-Vivo", (short) 80, (short) 6, "1d6 + 3", (short) 9, (short) 3);
    }

    Dado dado = new Dado();

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
