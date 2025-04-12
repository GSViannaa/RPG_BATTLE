public class Batalha
{
    private final Herois jogador;
    private final Monstros monstro;

    public Batalha(Herois jogador, Monstros monstro)
    {
        this.jogador = jogador;
        this.monstro = monstro;
    }

    public void iniciar()
    {
        System.out.println("\n=== A Batalha Começou ===");
        System.out.printf("%s vs %s\n", jogador.nome, monstro.nome);

        int iniciativaJogador = jogador.iniciativa(jogador.agilidade);
        int iniciativaMonstro = monstro.iniciativa(monstro.agilidade);

        boolean turnoJogador = iniciativaJogador >= iniciativaMonstro;

        while(jogador.estaVivo() && monstro.estaVivo())
        {
            if(turnoJogador)
            {

            }

        }

    }
}
