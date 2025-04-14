package Sistema;

import Entidades.Entidades;
import Entidades.Herois;
import Entidades.Monstros;

import java.util.List;
import java.util.Objects;
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
        System.out.println("\n==== A Batalha Começou ====");
        System.out.printf("  %s vs %s\n", jogador.getNome(), monstro.getNome());

        int iniciativaJogador = jogador.iniciativa(jogador.getAgilidade());
        int iniciativaMonstro = monstro.iniciativa(monstro.getAgilidade());

        boolean turnoJogador = iniciativaJogador >= iniciativaMonstro;


        while (jogador.estaVivo() && monstro.estaVivo())
        {

            if(turnoJogador)
            {
                turnoDoJogador();
            }
            else
            {
                turnoDoMonstro();
                aplicarAtaque(monstro, jogador);
            }

            turnoJogador = !turnoJogador;

        }

            terminarBatalha(jogador, monstro);


    }

    private void turnoDoJogador()
    {
        try
        {
            boolean isValid = true;

            System.out.printf("\n%s Seu turno! \n" , jogador.getNome());
            System.out.println("Escolha: \n");

            while (isValid)
            {
                System.out.println("1. Ataque Normal");
                System.out.println("2. Ataque Especial");

                String escolha =  input.nextLine();


                    switch (escolha)
                    {
                        case "1":
                            aplicarAtaque(jogador, monstro);
                            isValid = false;

                            break;

                        case "2":

                            List<Short> danosEspeciais = jogador.usarHabilidadeEspecial(jogador.getAtaqueMaximo());

                            if (danosEspeciais != null)
                            {
                                aplicarAtaqueEspecial(jogador, monstro, danosEspeciais, "Ataque Especial!");
                                isValid = false;
                            }
                            else
                            {
                                System.out.println("⚠️ Você já usou seu ataque especial! Escolha outra ação.");
                            }
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
        System.out.printf("\nTurno do %s \n" , monstro.getNome());

    }

    public void aplicarAtaque(Entidades atacante, Entidades defensor)
    {
        System.out.println("\n" + atacante.mensagemDeAtaque());

        List<Short> danos = atacante.calcularDano();
        int somaDanoBruto = 0;

        int danoFinal = 0;

        for (int i = 0; i < danos.size(); i++)
        {
            short danoBruto = danos.get(i);

            somaDanoBruto += danoBruto;

            System.out.printf("Ataque %d: %d de dano\n", i + 1, danoBruto);

            if(Objects.equals(atacante.getNome(), "Morto-Vivo"))
            {
                danoFinal += somaDanoBruto;
            }
            else
            {
                danoFinal = Math.max(somaDanoBruto - defensor.getDefesa(), 0);
            }

            int vidaRestante = defensor.getVida() - danoFinal;
            defensor.setVida((short) vidaRestante);

        }

        System.out.printf("Dano final causado: %d \n❤️ Vida restante de %s: %d\n", danoFinal, defensor.getNome(), defensor.getVida());

    }

    public void aplicarAtaqueEspecial(Entidades atacante, Entidades defensor, List<Short> danos, String mensagem)
    {
        System.out.println("\n" + mensagem);

        int soma = 0;

        for (int i = 0; i < danos.size(); i++)
        {
            short dano = danos.get(i);
            soma += dano;
            System.out.printf("Ataque %d: %d de dano\n", i + 1, dano);
        }


        int danoFinal = Math.max(soma - defensor.getDefesa(), 0);
        int vidaRestante = defensor.getVida() - danoFinal;
        defensor.setVida((short) vidaRestante);

        System.out.printf("Dano final causado: %d \n❤️ Vida restante de %s: %d\n", danoFinal, defensor.getNome(), defensor.getVida());

    }

    public void terminarBatalha(Herois jogador, Monstros monstro)
    {
       if(jogador.estaVivo())
       {
           System.out.printf("%s lutou com bravura e conquistou a vitória!\n", jogador.getNome());
       }
        else
       {
           System.out.printf("%s foi o ultimo em pé!Tente novamente.\n", monstro.getNome());
       }

    }


}
