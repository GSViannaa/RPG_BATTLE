package Monstros;

import Sistema.Dado;
import Entidades.Monstros;

import java.util.ArrayList;
import java.util.List;

public class Orc  extends Monstros
{

    public Orc()
    {
        super("Orc", (short) 100, (short) 6, "2d6 + 5", (short) 17, (short) 8);
    }
    Dado dado;

    @Override
    public int iniciativa(short agilidade)
    {
        return Dado.rolarIniciativa() + agilidade;
    }


    @Override
    public List<Short> calcularDano()
    {
        List<Short> danos = new ArrayList<>();
        danos.add((short) dado.rolarDano(this.ataqueMaximo));

        return danos;
    }

    @Override
    public String mensagemDeAtaque() {
        return "O brutal Orc ataca com força!";
    }
}
