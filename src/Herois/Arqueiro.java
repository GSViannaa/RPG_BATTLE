package Herois;

import Sistema.Dado;
import Entidades.Herois;

public class Arqueiro  extends Herois
{
    public Arqueiro(String nome)
    {
        super(nome, (short) 90, (short) 9, "1d8", (short) 8, (short) 8, false);
    }
    Dado dado;

    public static void exibirStatus()
    {
        System.out.println("\n====== Entidades.Herois.Arqueiro ======");
        System.out.println("Vida: 90 ");
        System.out.println("Agilidade: 9 ");
        System.out.println("Defesa: 8 ");
        System.out.println("Ataque: 1d8 + 2");
        System.out.println("Ataque Especial: Chuva de flecas");
        System.out.println("========================");

    }
    @Override
    public void usarHabilidadeEspecial(short ataqueMaximo)
    {
        short danoCausado = (short) ((short) ataqueMaximo * 4);

        if (!usouAtaqueEspecial)
        {
            System.out.printf("%s usou 'Chuva de Flechas'! ", nome);
            System.out.printf("Suas flechas caem do céu e causam %d de dano!\n", danoCausado);

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
