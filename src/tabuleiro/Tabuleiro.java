package src.tabuleiro;

import java.util.List;
import src.casa.Casa;
import src.jogador.Jogador;

public class Tabuleiro {
    private final int LINHAS = 4;
    private final int COLUNAS = 10;

    public Tabuleiro () {}

    private int calcularNumeroDaCasa(int linha, int coluna) {
        int base = linha * 10;

        if (linha % 2 == 0) {
            return base + coluna;
        } else {
            return base + (9 - coluna);
        }
    }

    private void montarBorda () {
        for (int i = 0; i < COLUNAS; i++) {
            System.out.print("+----");
        }

        System.out.print("+\n");
    }

    private void montarLinha (List<Jogador> jogadores, List<Casa> casas, int linha) {
        Casa casa = new Casa(0);
        boolean jogadorNaCasa = false;

        for (int coluna = 0; coluna < COLUNAS; coluna++) {
            casa = casas.get(calcularNumeroDaCasa(linha, coluna));
            
            for (Jogador jogador : jogadores) {
                if (jogador.getNumeroAtualDaCasa() == casa.getNumeroDaCasa()) {
                    jogadorNaCasa = true;
                }
            }

            System.out.printf("| %2s ", casa.jogadorNaCasa(jogadorNaCasa));

            jogadorNaCasa = false;
        }

        System.out.print("|\n");
    }

    public void ImprimirTabuleiro (List<Jogador> jogadores, List<Casa> casas) {
        for (int i = 0; i < LINHAS; i++){
            montarBorda();
            montarLinha(jogadores, casas, i);
        }

        montarBorda();
    }
}