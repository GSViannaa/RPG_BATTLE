package Herois;

import Sistema.Dado;
import Entidades.Herois;

import java.util.ArrayList;
import java.util.List;

public class Mago extends Herois {

    public Mago(String nome) {
        super(nome, (short) 60, (short) 5 , "1d16 + 5", (short) 21, (short) 6, false);
    }

    Dado dado;

    public static void exibirStatus() {
        System.out.println("\n======= Mago ========");
        System.out.println("Vida: 60 ");
        System.out.println("Agilidade: 5");
        System.out.println("Defesa: 6 ");
        System.out.println("Ataque: 1d16 + 5");
        System.out.println("Ataque Especial: Bola de Fogo");
        System.out.println("==============================");
    }

    @Override
    public List<Short> usarHabilidadeEspecial(short ataqueMaximo)
    {
        List<Short> danos = new ArrayList<>();

        if(!usouAtaqueEspecial)
        {
            short danoCausado = (short) (ataqueMaximo + 14);
            danos.add(danoCausado);

            System.out.printf("%s convoca ma imensa bola de fogo dos céus'!\n", nome);

            usouAtaqueEspecial = true;

        }
        else
        {
            System.out.println("Você já usou o ataque especial!");
            return null;

        }

        return danos;
    }

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
        return "Você convoca raios e queima seu oponete com todo seu poder!";
    }
}