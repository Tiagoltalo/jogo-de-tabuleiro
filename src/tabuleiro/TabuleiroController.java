package src.tabuleiro;

import java.util.List;
import src.casa.Casa;
import src.jogador.Jogador;

public class TabuleiroController {
    private Tabuleiro tabuleiro = new Tabuleiro();

    public TabuleiroController () {}
    
    public void criarEAtualizarTabuleiro (List<Jogador> jogadores, List<Casa> casas) {
        tabuleiro.ImprimirTabuleiro(jogadores, casas);
    }
}
