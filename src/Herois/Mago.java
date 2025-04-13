package Herois;

import Sistema.Dado;
import Entidades.Herois;

public class Mago extends Herois {

    public Mago(String nome) {
        super(nome, (short) 70, (short) 5 , "1d16 + 2", (short) 18, (short) 4, false);
    }

    Dado dado;

    public static void exibirStatus() {
        System.out.println("\n======= Entidades.Entidades.Herois.Mago ========");
        System.out.println("Vida: 70 ");
        System.out.println("Agilidade: 5");
        System.out.println("Defesa: 4 ");
        System.out.println("Ataque: 1d16 + 2");
        System.out.println("Ataque Especial: Bola de Fogo");
        System.out.println("==============================");
    }

    @Override
    public void usarHabilidadeEspecial(short ataqueMaximo)
    {
        if(!usouAtaqueEspecial)
        {
            short danoCausado = (short) (ataqueMaximo + 6);

            System.out.printf("%s lança 'Bola de Fogo'!\n", nome);
            System.out.printf("Uma imensa bola de fogo cai do céu e causa %d de danoDado!\n", danoCausado);

            usouAtaqueEspecial = true;

        }
        else
        {
            System.out.println("Você já usou o ataque especial!");

        }
    }

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() + agilidade;
    }

    @Override
    public int dano(short ataqueMaximo)
    {
        return (short) dado.rolar(ataqueMaximo);
    }
}