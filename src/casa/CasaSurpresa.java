package src.casa;

import java.util.List;
import java.util.Random;

import src.jogador.Jogador;

public class CasaSurpresa extends Casa {
    private Random random = new Random();
    private String nome = "Casa Surpresa";

    public CasaSurpresa (int numeroDaCasa) {
        super(numeroDaCasa);
    }

    public String jogadorNaCasa (boolean estaJogador, int quantidadeDeJogadores) {
        return super.jogadorNaCasa(estaJogador, quantidadeDeJogadores);
    }

    public String funcaoEspecial (List<Jogador> jogadores, int indice) {
        Jogador jogador = jogadores.get(indice);
        int resultado = random.nextInt(1, 1000);
        int divisores = 0;
        int casaAtual = jogador.getNumeroAtualDaCasa();
        String nome = jogador.getNome();
        String cor = jogador.getCor();
        String tipo;
        String tipoMensagem;

        for (int i = 1; i < resultado; i++) {
            if (resultado % i == 0) {
                divisores++;
            }
        }

        if (divisores == 2) {
            tipo = "jogadorsortudo";
            tipoMensagem = "sortudo";
        } else if (resultado % 2 == 0) {
            tipo = "jogadornormal";
            tipoMensagem = "normal";
        } else {
            tipo = "jogadorazarado";
            tipoMensagem = "azarado";
        }
        
        Jogador jogadorAtualizado = new Jogador(nome, cor, tipo);

        jogadorAtualizado.pularCasas(casaAtual);

        jogadores.set(indice, jogadorAtualizado);

        return "O jogador " + jogador.getNome() + " caiu na casa " + this.nome + ".\nVocê agora é um jogador " + tipoMensagem;
    }
}