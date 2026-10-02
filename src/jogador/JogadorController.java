package src.jogador;

import java.util.List;

import src.utils.Utils;

public class JogadorController {
    private Utils utils = new Utils();
    private JogadorView jogadorView = new JogadorView();
    private Jogador jogador = new Jogador(null, null, null);

    public JogadorController () {}

    public Jogador criarJogador () {
        String nome;
        String cor;
        String tipo;

        utils.limparTerminal();
        nome = jogadorView.lerNome();
        cor = jogadorView.lerCor();
        tipo = jogadorView.lerTipo();

        if (tipo.equals("jogadornormal")) {
            jogador = new Jogador(nome, cor, tipo);
        } else if (tipo.equals("jogadorsortudo")) {
            jogador = new JogadorSortudo(nome, cor);
        } else if (tipo.equals("jogadorazarado")) {
            jogador = new JogadorAzarado(nome, cor);
        }

        return jogador;
    }

    public void mostrarJogadores (List<Jogador> jogadores) {
        jogadorView.imprimirJogadores(jogadores);
    }

    public boolean jogada (Jogador jogador) {
        int[] valorDosDados;
        boolean jogarDadosNovamente= false;

        utils.limparTerminal();

        utils.mostrarMensagem("Jogador: " + jogador.getNome() + " - Casa: " + jogador.getNumeroAtualDaCasa());
        utils.mostrarMensagem("\n\nJogar Dados");
        utils.pausar();

        valorDosDados = jogador.jogarDados();
        jogador.pularCasas(valorDosDados[0]);

        utils.mostrarMensagem("\nValor dos Dados ⚄ ⚂ - " + valorDosDados[0]);
        utils.pausar();

        if (valorDosDados[1] == 1) {
            jogarDadosNovamente = true;
        }

        return jogarDadosNovamente;
    }
}
