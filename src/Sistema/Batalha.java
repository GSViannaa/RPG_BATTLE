package Sistema;

import Entidades.Herois;
import Entidades.Monstros;

import java.util.Scanner;

public class Batalha
{
    private final Herois jogador;
    private final Monstros monstro;

    Scanner input = new Scanner(System.in);




    public Batalha(Herois jogador, Monstros monstro)
    {
        this.jogador = jogador;
        this.monstro = monstro;
    }

    public void iniciar()
    {
        System.out.println("\n==== A Sistema.Batalha Começou ====");
        System.out.printf("  %s vs %s\n", jogador.nome, monstro.nome);

        int iniciativaJogador = jogador.iniciativa(jogador.agilidade);
        int iniciativaMonstro = monstro.iniciativa(monstro.agilidade);

        boolean turnoJogador = iniciativaJogador >= iniciativaMonstro;


        do {

            if(turnoJogador)
            {
                turnoDoJogador();
            }
            else
            {
                turnoDoMonstro();
            }

        } while (jogador.estaVivo() || monstro.estaVivo());





    }

    private void turnoDoJogador()
    {
        try
        {
            boolean isValid = true;

            System.out.printf("\n%s Seu turno! \n" , jogador.nome);
            System.out.println("Escolha: \n");

            while (isValid)
            {
                System.out.println("1. Ataque Normal");
                System.out.println("2. Ataque Especial");

                String escolha =  input.nextLine();


                    switch (escolha)
                    {
                        case "1":
                            jogador.dano(jogador.ataqueMaximo);
                            isValid = false;

                            break;

                        case "2":
                            jogador.usarHabilidadeEspecial(jogador.ataqueMaximo);
                            isValid = false;

                            break;

                        default:
                            System.out.println("Escolha um opcao valida!");

                            break;

                    }


            }


        }
        catch (Exception e)
        {
            System.out.println("Erro ao tentar iniciar: " + e);
        }

    }

    private void  turnoDoMonstro()
    {
        System.out.printf("\nTurno do %s \n" , monstro.nome);

    }
}
