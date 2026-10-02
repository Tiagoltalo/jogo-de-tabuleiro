package src.casa;

import java.util.List;

import src.jogador.Jogador;

public class CasaDaSorte extends Casa {
    public CasaDaSorte (int numeroDaCasa) {
        super(numeroDaCasa);
    }

    public String jogadorNaCasa (boolean estaJogador) {
        return super.jogadorNaCasa(estaJogador);
    }

    public void funcaoEspecial (List<Jogador> jogadores, int indice) {
        Jogador jogador = jogadores.get(indice);

        if (jogador.getTipo().equals("jogadorazarado")) {
            
        } else {
            jogador.pularCasas(3);
        }
    }
}
