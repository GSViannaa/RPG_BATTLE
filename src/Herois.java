public abstract class Herois extends Entidades
{
    public Herois(String nome, short vida, short agilidade, String dano, short ataque, short defesa)
    {
        super(nome, vida, agilidade, dano, ataque, defesa);
    }



    public abstract short usarHabilidadeEspecial(short forca);

    public boolean usouHabilidadeEspecial()
    {
        return false;
    }


}
