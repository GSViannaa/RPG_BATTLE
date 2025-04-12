public abstract class Entidades
{
    protected String nome;
    protected short vida;
    protected short agilidade;
    protected String dano;
    protected short ataque;
    protected short defesa;

    public Entidades(String nome, short vida, short agilidade, String dano, short ataque, short defesa)
    {
        this.nome = nome;
        this.vida = vida;
        this.agilidade = agilidade;
        this.dano = dano;
        this.ataque = ataque;
        this.defesa = defesa;
    }


    public abstract int iniciativa(short agilidade);

    public abstract int dano(short forca);

    public  void receberDano(short dano)
    {
        vida = (short) (vida - (defesa - dano));
        System.out.printf("%s recebeu %d de deno. Vida restante: %d", nome, dano, vida);
    }

    public boolean estaVivo()
    {
        return vida <= 0;
    }

}
