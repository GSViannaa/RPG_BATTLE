import java.util.Random;

public class Guerreiro extends Herois
{
    public Guerreiro(String nome)
    {
        super(nome, (short) 120, (short) 6, "2d6", (short) 12, (short) 10);
    }

    Dado dado;


    public static void exibirStatus()
    {
        System.out.println("\n===== Guerreiro =====");
        System.out.println("Vida: 120 ");
        System.out.println("Agilidade: 6 ");
        System.out.println("Defesa: 10 ");
        System.out.println("Ataque: 2d6");
        System.out.println("Ataque Especial: Fúria");
        System.out.println("======================");

    }

    @Override
    public short usarHabilidadeEspecial(short forca)
    {
        Random rand = new Random();
        int ataques = rand.nextInt(3) + 1;

        System.out.printf("%s usa 'Fúria'! e ataca %d vezes\n", nome, ataques);

        return (short) (forca + 2 *  (short) ataques);

    }

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() +  agilidade;
    }

    @Override
    public int dano(short ataque)
    {
        return dado.rolarDano(ataque);
    }
}
