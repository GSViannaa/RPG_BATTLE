public class Arqueiro  extends Herois
{
    public Arqueiro(String nome)
    {
        super(nome, (short) 90, (short) 8, "1d8", (short) 8, (short) 8);
    }
    Dado dado;

    public static void exibirStatus()
    {
        System.out.println("\n====== Arqueiro ======");
        System.out.println("Vida: 90 ");
        System.out.println("Agilidade: 8 ");
        System.out.println("Defesa: 8 ");
        System.out.println("Ataque: 1d8 + 2");
        System.out.println("Ataque Especial: Chuva de flecas");
        System.out.println("========================");

    }
    @Override
    public short usarHabilidadeEspecial(short dano)
    {
        System.out.printf("%s usou 'Chuva de Flechas'! ", nome);

        return (short) ((short) dano * 4);
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
