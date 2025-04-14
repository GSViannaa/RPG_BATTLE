package Herois;

import Sistema.Dado;
import Entidades.Herois;

import java.util.ArrayList;
import java.util.List;

public class Arqueiro  extends Herois
{
    public Arqueiro(String nome)
    {
        super(nome, (short) 90, (short) 9, "1d8 + 2", (short) 10, (short) 8, false);
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
    public List<Short> usarHabilidadeEspecial(short ataqueMaximo)
    {
        List<Short> danos = new ArrayList<>();


        if (!usouAtaqueEspecial)
        {
            short danoCausado = (short) ((short) ataqueMaximo * 4);
            danos.add(danoCausado);

            System.out.printf("%s usou 'Chuva de Flechas'! Suas flechas caem do céu ", nome);
            System.out.printf(" e causam %d de dano!\n", danoCausado);

            usouAtaqueEspecial = true;

        }
        else
        {
            System.out.println("Você ja usou o ataque especial!");
            return null;
        }
        return danos;

    }

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() +  agilidade;
    }



    @Override
    public List<Short> calcularDano() {
        List<Short> danos = new ArrayList<>();
        danos.add((short) dado.rolarDano(this.ataqueMaximo));

        return danos;
    }

    @Override
    public String mensagemDeAtaque() {
        return "Você atira uma flecha certeira!";
    }
}
