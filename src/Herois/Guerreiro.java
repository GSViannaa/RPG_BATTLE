package Herois;

import Entidades.Herois;
import Sistema.Dado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guerreiro extends Herois
{
    public Guerreiro(String nome)
    {
        super(nome, (short) 90, (short) 7, "3d6 + 2", (short) 20, (short) 8, false);
    }

    Dado dado;


    public static void exibirStatus()
    {
        System.out.println("\n===== Guerreiro =====");
        System.out.println("Vida: 90 ");
        System.out.println("Agilidade: 8 ");
        System.out.println("Defesa: 8 ");
        System.out.println("Ataque: 3d6 + 2");
        System.out.println("Ataque Especial: Fúria");
        System.out.println("======================");

    }


    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() +  agilidade;
    }


    @Override
    public List<Short> calcularDano()
    {
        List <Short> danos = new ArrayList<>();
        danos.add((short) dado.rolarDano((short) (this.ataqueMaximo + 3)));

        return danos;
    }

    @Override
    public String mensagemDeAtaque() {
        return "Você corta o oponente com toda sua força!";
    }

    @Override
    public List<Short> usarHabilidadeEspecial(short ataqueMaximo)
    {
        List<Short> danos = new ArrayList<>();

        if(!usouAtaqueEspecial)
        {
            Random rand = new Random();
            int ataques = rand.nextInt(3) + 1;



            System.out.printf("%s usa 'Fúria'! e ataca %d vezes\n", nome, ataques);

            for(int i = 0; i < ataques; i++)
            {
                short dano = (short) (dado.rolarDano(ataqueMaximo));
                danos.add(dano);
            }

            usouAtaqueEspecial = true;

        }
        else
        {
            System.out.println("Você ja usou o ataque especial!");
            return null;

        }

        return danos;
    }

}
