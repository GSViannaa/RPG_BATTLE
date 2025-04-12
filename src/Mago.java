public class Mago extends Herois {

    public Mago(String nome) {
        super(nome, (short) 70, (short) 5 , "1d16 + 2", (short) 18, (short) 4);
    }

    Dado dado;

    public static void exibirStatus() {
        System.out.println("\n======= Mago ========");
        System.out.println("Vida: 70 ");
        System.out.println("Agilidade: 5");
        System.out.println("Defesa: 4 ");
        System.out.println("Ataque: 1d16 + 2");
        System.out.println("Ataque Especial: Bola de Fogo");
        System.out.println("==============================");
    }

    @Override
    public short usarHabilidadeEspecial(short dano)
    {
        System.out.printf("%s lança 'Bola de Fogo'!\n", nome);
        return (short) (dano + 6);
    }

    @Override
    public int iniciativa(short agilidade)
    {
        return dado.rolarIniciativa() + agilidade;
    }

    @Override
    public int dano(short ataque)
    {
        return (short) dado.rolar(ataque);
    }
}