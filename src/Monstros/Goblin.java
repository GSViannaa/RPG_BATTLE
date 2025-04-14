package Monstros;

import Sistema.Dado;
import Entidades.Monstros;

import java.util.ArrayList;
import java.util.List;

public class Goblin  extends Monstros
{
    public Goblin()
    {
        super("Goblin", (short) 65, (short) 14, "3d6", (short) 18, (short) 5);
    }
    Dado dado;

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() + agilidade;
    }



    @Override
    public List<Short> calcularDano()
    {
        List<Short> danos = new ArrayList<>();
        danos.add((short) dado.rolarDano(this.ataqueMaximo));
        danos.add((short) dado.rolarDano(this.ataqueMaximo));

        return danos;
    }

    @Override
    public String mensagemDeAtaque()
    {
        return "O ágil Goblin ataca duas vezes com sua adaga!";
    }
}
