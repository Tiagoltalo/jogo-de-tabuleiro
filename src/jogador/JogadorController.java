package src.jogador;

import java.util.List;
import src.utils.Utils;
import src.exceptions.EntradaInvalidaException;
import src.exceptions.LeituraValidada;

public class JogadorController {
    private Utils utils = new Utils();
    private JogadorView jogadorView = new JogadorView();
    private Jogador jogador = new Jogador(null, null, null);

    public JogadorController () {}

    private <T> T lerAteSerValidado (LeituraValidada<T> leitura) {
        while (true) {
            try {
                return leitura.ler();
            } catch (EntradaInvalidaException e) {
                utils.mostrarMensagem("\n" + e.getMessage() + ".\n");
            }
        }
    }

    public Jogador criarJogador () throws EntradaInvalidaException {
        String nome;
        String cor;
        String tipo;

        utils.limparTerminal();
        
        nome = lerAteSerValidado(jogadorView::lerNome);
        cor = lerAteSerValidado(jogadorView::lerCor);
        tipo = lerAteSerValidado(jogadorView::lerTipo);

        switch (tipo) {
            case "jogadornormal": return new Jogador(nome, cor, tipo);
            case "jogadorsortudo": return new Jogador(nome, cor, tipo);
            case "jogadorazarado": return new Jogador(nome, cor, tipo);
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
