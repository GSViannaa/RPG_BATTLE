import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Herois jogador;
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

             switch (escolha) {
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
                 break;
             }

         }


        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e);
            return;
        }


        System.out.println("Escolha seu nome:");
        String nome = input.nextLine();

        switch (escolha)
        {
            case 1 -> jogador = new Guerreiro(nome);
            case 2 -> jogador = new Arqueiro(nome);
            case 3 -> jogador = new Mago(nome);

            default -> System.out.println("Escolha uma opção válida!");
        }

    }
}