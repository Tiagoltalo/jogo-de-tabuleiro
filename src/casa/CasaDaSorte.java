package src.casa;

import java.util.List;

import src.jogador.Jogador;

public class CasaDaSorte extends Casa {
    private String nome = "Casa da Sorte";

    public CasaDaSorte (int numeroDaCasa) {
        super(numeroDaCasa);
    }

    public String jogadorNaCasa (boolean estaJogador) {
        return super.jogadorNaCasa(estaJogador);
    }

    public String funcaoEspecial (List<Jogador> jogadores, int indice) {
        Jogador jogador = jogadores.get(indice);

        if (!jogador.getTipo().equals("jogadorazarado")) {
            jogador.pularCasas(3);
        }

        return "O jogador " + jogador.getNome() + " caiu na " + this.nome + ".\nVocê pula mais 3 casas, caso não seja um jogador azarado.";
    }
}
