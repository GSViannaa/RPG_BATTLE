package Entidades;

public abstract class Herois extends Entidades
{
    protected boolean usouAtaqueEspecial = false;

    public Herois(String nome, short vida, short agilidade, String danoDado, short ataqueMaximo, short defesa, boolean usouAtaqueEspecial)
    {
        super(nome, vida, agilidade, danoDado, ataqueMaximo, defesa);
    }


    public abstract void usarHabilidadeEspecial(short forca);


}
