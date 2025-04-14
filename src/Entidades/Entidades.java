package Entidades;

import java.util.List;

public abstract class Entidades
{


    protected String nome;
    protected short vida;
    protected short agilidade;
    protected String danoDado;
    protected short ataqueMaximo;
    protected short defesa;

    public Entidades(String nome, short vida, short agilidade, String danoDado, short ataqueMaximo, short defesa)
    {
        this.nome = nome;
        this.setVida(vida);

        this.agilidade = agilidade;
        this.danoDado = danoDado;

        this.ataqueMaximo = ataqueMaximo;
        this.setDefesa(defesa);
    }


    public abstract int iniciativa(short agilidade);


   public abstract List<Short> calcularDano();

   public abstract String mensagemDeAtaque();

    public boolean estaVivo()
    {
        return getVida() >= 0;
    }

    public short getVida()
    {
        return vida;
    }

    public void setVida(short vida) {

        this.vida = vida;
    }

    public String getNome()
    {
        return nome;
    }

    public short getDefesa()
    {
        return defesa;
    }

    public void setDefesa(short defesa)
    {
        this.defesa = defesa;
    }

    public short getAtaqueMaximo()
    {
        return ataqueMaximo;
    }

    public short getAgilidade() {
        return agilidade;
    }
}
