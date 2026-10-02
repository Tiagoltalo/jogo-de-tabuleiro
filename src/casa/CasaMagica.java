package src.casa;

import java.util.List;
import src.jogador.Jogador;

public class CasaMagica extends Casa {
    public CasaMagica (int numeroDaCasa) {
        super(numeroDaCasa);
    }

    public String jogadorNaCasa (boolean estaJogador) {
        return super.jogadorNaCasa(estaJogador);
    }

    public void funcaoEspecial (List<Jogador> jogadores, int indice) {
        Jogador jogador1 = jogadores.get(indice);
        Jogador jogador2 = jogadores.get(indice);
        int diferenca;

        for (Jogador jogador : jogadores) {
            if (jogador2.getNumeroAtualDaCasa() > jogador.getNumeroAtualDaCasa()) {
                jogador2 = jogador;
            }
        }

        diferenca = jogador1.getNumeroAtualDaCasa() - jogador2.getNumeroAtualDaCasa();

        jogador1.voltarCasas(diferenca);
        jogador2.pularCasas(diferenca);
    }
}
