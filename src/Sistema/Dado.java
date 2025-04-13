package Sistema;

import java.util.Random;

public class Dado
{
    private static final Random random = new Random();

    public static int rolar(int lados)
    {
        return random.nextInt(lados) + 1;
    }

    public static int rolarIniciativa()
    {
        return rolar(20);
    }

    public  static int rolarDano(short ataque)
    {
        return Dado.rolar(ataque);
    }


}
