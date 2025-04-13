package Entidades;

public abstract class Entidades
{
    public String nome;
    protected short vida;
    public short agilidade;
    protected String danoDado;
    public short ataqueMaximo;
    protected short defesa;

    public Entidades(String nome, short vida, short agilidade, String danoDado, short ataqueMaximo, short defesa)
    {
        this.nome = nome;
        this.vida = vida;

        this.agilidade = agilidade;
        this.danoDado = danoDado;

        this.ataqueMaximo = ataqueMaximo;
        this.defesa = defesa;
    }


    public abstract int iniciativa(short agilidade);

    public abstract int dano(short ataqueMaximo);

    public  void receberDano(short dano)
    {
        vida = (short) (vida - (defesa - dano));
        System.out.printf("%s recebeu %d de danoDado. Vida restante: %d", nome, dano, vida);
    }

    public boolean estaVivo()
    {
        return vida <= 0;
    }

}
