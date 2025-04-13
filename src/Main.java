import Entidades.Monstros;
import Entidades.Herois;
import Sistema.Batalha;
import Sistema.FaseSelecao;

public class Main
{
    public static void main(String[] args)
    {
       Herois jogador =  FaseSelecao.escolherPersonagem();
       Monstros monstro = FaseSelecao.escolherMonstro();

       Batalha batalha = new Batalha(jogador, monstro);

       batalha.iniciar();

    }
}