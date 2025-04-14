package Monstros;

import Sistema.Dado;
import Entidades.Monstros;

import java.util.ArrayList;
import java.util.List;

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
    public List<Short> calcularDano()
    {
        List<Short> danos = new ArrayList<>();
        danos.add((short) dado.rolarDano(this.ataqueMaximo));


        return danos;
    }

    @Override
    public String mensagemDeAtaque() {
        return "O feroz Morto-Vivo morde com força e ignora sua defesa!";
    }
}
