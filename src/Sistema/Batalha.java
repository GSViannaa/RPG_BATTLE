package Sistema;

import Entidades.Entidades;
import Entidades.Herois;
import Entidades.Monstros;

import java.util.List;
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
                            aplicarAtaque(jogador, monstro);
                            isValid = false;

                            break;

                        case "2":

                            List<Short> danosEspeciais = jogador.usarHabilidadeEspecial(jogador.ataqueMaximo);

                            if (danosEspeciais != null)
                            {
                                aplicarAtaquePersonalizado(jogador, monstro, danosEspeciais, "Ataque Especial!");
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
        System.out.printf("\nTurno do %s \n" , monstro.nome);

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

            danoFinal = Math.max(somaDanoBruto - defensor.getDefesa(), 0);
            defensor.setVida((short) (defensor.getVida() - danoFinal));

        }

        System.out.printf("Dano final causado: %d \n❤️ Vida restante de %s: %d\n", danoFinal, defensor.getNome(), defensor.getVida());

    }

    public void aplicarAtaquePersonalizado(Entidades atacante, Entidades defensor, List<Short> danos, String mensagem)
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
        defensor.setVida((short) (defensor.getVida() - danoFinal));

        System.out.printf("Dano final causado: %d \n❤️ Vida restante de %s: %d\n", danoFinal, defensor.getNome(), defensor.getVida());

    }

}
