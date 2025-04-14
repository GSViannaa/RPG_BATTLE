package Herois;

import Sistema.Dado;
import Entidades.Herois;

import java.util.ArrayList;
import java.util.List;

public class Arqueiro  extends Herois
{
    public Arqueiro(String nome)
    {
        super(nome, (short) 85, (short) 9, "2d8 + 4", (short) 20, (short) 6, false);
    }
    Dado dado;

    public static void exibirStatus()
    {
        System.out.println("\n====== Arqueiro ======");
        System.out.println("Vida: 85 ");
        System.out.println("Agilidade: 9 ");
        System.out.println("Defesa: 6 ");
        System.out.println("Ataque: 2d8 + 4");
        System.out.println("Ataque Especial: Chuva de flecas");
        System.out.println("========================");

    }
    @Override
    public List<Short> usarHabilidadeEspecial(short ataqueMaximo)
    {
        List<Short> danos = new ArrayList<>();


        if (!usouAtaqueEspecial)
        {
            short danoCausado = (short) ((short)  ataqueMaximo * 3);
            danos.add(danoCausado);

            System.out.printf("%s usou 'Chuva de Flechas'!Suas flechas caem do céu!", nome);
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
