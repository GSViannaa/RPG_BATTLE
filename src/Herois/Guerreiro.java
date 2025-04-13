package Herois;

import Entidades.Herois;
import Sistema.Dado;
import java.util.Random;

public class Guerreiro extends Herois
{
    public Guerreiro(String nome)
    {
        super(nome, (short) 120, (short) 8, "2d6", (short) 12, (short) 10, false);
    }

    Dado dado;


    public static void exibirStatus()
    {
        System.out.println("\n===== Entidades.Entidades.Herois.Guerreiro =====");
        System.out.println("Vida: 120 ");
        System.out.println("Agilidade: 8 ");
        System.out.println("Defesa: 10 ");
        System.out.println("Ataque: 2d6");
        System.out.println("Ataque Especial: Fúria");
        System.out.println("======================");

    }

    @Override
    public void usarHabilidadeEspecial(short ataqueMaximo)
    {
        if(!usouAtaqueEspecial)
        {
            Random rand = new Random();
            int ataques = rand.nextInt(3) + 1;

            short dano = (short) ((dado.rolarDano(ataqueMaximo) + 2) * (short) ataques);

            System.out.printf("%s usa 'Fúria'! e ataca %d vezes\n", nome, ataques);
            System.out.printf("Você causa %d de dano! \n",  dano);

            usouAtaqueEspecial = true;

        }
        else
        {
            System.out.println("Você ja usou o ataque especial!");

        }
    }

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() +  agilidade;
    }

    @Override
    public int dano(short ataqueMaximo)
    {
        return dado.rolarDano(ataqueMaximo);
    }
}
