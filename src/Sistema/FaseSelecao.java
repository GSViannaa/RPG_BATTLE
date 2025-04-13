package Sistema;

import Entidades.Herois;
import Entidades.Monstros;
import Herois.Arqueiro;
import Herois.Guerreiro;
import Herois.Mago;
import Monstros.Goblin;
import Monstros.Morto_Vivo;
import Monstros.Orc;

import java.util.Scanner;


public class FaseSelecao {


        public static Herois escolherPersonagem()
        {

            Scanner input = new Scanner(System.in);

            Herois jogador = null;
            int escolha = 0;

            boolean continuar = true;

            try {
                while (continuar)
                {
                    System.out.println("Escolha seu personagem:");
                    System.out.println("1. Guerreiro");
                    System.out.println("2. Arqueiro");
                    System.out.println("3. Mago");

                    escolha = input.nextInt();
                    input.nextLine();

                    System.out.print("\nStatus do personagem: \n");

                    switch (escolha)
                    {
                        case 1 -> Guerreiro.exibirStatus();
                        case 2 -> Arqueiro.exibirStatus();
                        case 3 -> Mago.exibirStatus();

                        default -> {
                            System.out.println("Escolha uma opção válida!\n");
                            continue;
                        }
                    }

                    System.out.println("\n1. Confirmar escolha");
                    System.out.println("2. Voltar");

                    int escolha2 = input.nextInt();
                    input.nextLine();

                    if (escolha2 == 1) {
                        continuar = false;
                    }
                }

                System.out.println("Escolha seu nome:");
                String nome = input.nextLine();

                switch (escolha)
                {
                    case 1 -> jogador = new Guerreiro(nome);
                    case 2 -> jogador = new Arqueiro(nome);
                    case 3 -> jogador = new Mago(nome);

                    default -> System.out.println("Erro ao escolher personagem.");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            return jogador;
        }


      public static Monstros escolherMonstro()
      {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEscolha seu oponente: ");
        System.out.println("\n1. Orc \n2. Goblin \n3. Morto-Vivo");


        int escolha = 0;

        while (escolha < 1 || escolha > 3)
        {
            System.out.println("Digite o número do monstro: ");
            escolha = input.nextInt();
        }


        return switch (escolha)
        {
            case 1 -> new Orc();
            case 2 -> new Goblin();
            case 3 -> new Morto_Vivo();
            default -> throw new IllegalArgumentException("Escolha inválida de personagem");

        };

       }
    }

