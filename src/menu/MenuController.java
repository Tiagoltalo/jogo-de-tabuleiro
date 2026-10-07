package src.menu;

import java.util.List;
import java.util.ArrayList;
import src.utils.Utils;
import src.tabuleiro.TabuleiroController;
import src.casa.CasaController;
import src.casa.Casa;
import src.jogador.JogadorController;
import src.jogador.Jogador;
import src.exceptions.EntradaInvalidaException;

public class MenuController {
    private Utils utils = new Utils();
    private MenuView menuView = new MenuView();
    private TabuleiroController tabuleiroController = new TabuleiroController();
    private CasaController casaController = new CasaController();
    private JogadorController jogadorController = new JogadorController();
    private List<Casa> casas = casaController.criarCasas();
    private List<Jogador> jogadores = new ArrayList<>();

    private String mensagem;

    public MenuController () {

    }

    public int menu () {
        utils.limparTerminal();
        menuView.imprimirMenu();
        return menuView.lerOpcao();
    }

    public int menuDeModoDeJogo () {
        utils.limparTerminal();
        menuView.imprimirMenuModoDeJogo();
        return menuView.lerOpcao();
    }

    public void iniciarJogo (int modoDeJogo) {
        List<Jogador> naoJogamNaRodada = new ArrayList<>(); // Armazena os jogadores que não jogam na rodada
        Jogador jogadorVencedor = new Jogador(null, null, null); // Armazena a instância do jogador que venceu
        boolean jogadoresDeTipoDiferente = false;
        boolean looping = true;
        int rodadasNaoJogadas = 0; // Garante que os jogadores não joguem somente durante uma rodada
        int rodadas = 0;

        // Verificando se há, ao menos, dois jogadores de tipos diferentes
        String tipo = jogadores.get(0).getTipo();

        for (Jogador jogador : jogadores) {
            if (!jogador.getTipo().equals(tipo)) {
                jogadoresDeTipoDiferente = true;
                break;
            }
        }

        // Looping do jogo principal
        if (jogadores.size() >= 2 && jogadoresDeTipoDiferente) {
            while (looping) {
                rodadas++;
                utils.limparTerminal();
                utils.mostrarMensagem("Rodada - " + rodadas + "\n\n");
                tabuleiroController.criarEAtualizarTabuleiro(jogadores, casas);
                jogadorController.mostrarJogadores(jogadores);
                utils.pausar();
    
                for (Jogador jogador : jogadores) {
                    if (naoJogamNaRodada.contains(jogador)) {
                        rodadasNaoJogadas++;
                        continue;
                    }

                    estruturaDeJogada(jogador, modoDeJogo);
                    
                    if (jogador.getNumeroAtualDaCasa() >= 40) {
                        jogadorVencedor = jogador;
                        looping = false;
                        break;
                    }
                    

                    if (jogador.getNumeroAtualDaCasa() == 10 || jogador.getNumeroAtualDaCasa() == 25 || jogador.getNumeroAtualDaCasa() == 38) {
                        utils.limparTerminal();
                        utils.mostrarMensagem("O jogador " + jogador.getNome() + " caiu na Casa do Azar.\nNão jogará a próxima rodada.");
                        utils.pausar();

                        naoJogamNaRodada.add(jogador);
                    }

                    casaController.acaoDasCasas(casas, jogadores, jogador);
                }

                if (rodadasNaoJogadas >= 1) {
                    naoJogamNaRodada.clear();
                    rodadasNaoJogadas = 0;
                }
            }

            mensagem = "O jogador " + jogadorVencedor.getNome() + " - " + jogadorVencedor.getCor() + " ganhou o jogo!!!";

            utils.limparTerminal();
            utils.mostrarMensagem(mensagem);
        } else {
            mensagem = "Não há jogadores suficientes no jogo ou de tipos diferentes!!!";

            utils.limparTerminal();
            utils.mostrarMensagem(mensagem);
        }

        utils.pausar();
    }

    public void criarJogador () throws EntradaInvalidaException{
        utils.limparTerminal();
        jogadores.add(jogadorController.criarJogador());
        mensagem = "\nJogador criado com sucesso!!!";
        utils.mostrarMensagem(mensagem);
        utils.pausar();
    }

    public void sair () {
        utils.limparTerminal();
        mensagem = "\nObrigado por jogar!!!";
        utils.mostrarMensagem(mensagem);
        utils.pausar();
    }

    private void estruturaDeJogada (Jogador jogador, int modoDeJogo) {
        boolean looping = true;
        int valorDaCasa;
        int diferenca;

        if (modoDeJogo == 1) {
            // Verifica se o jogador irá jogar mais uma vez nessa rodada
            if(jogadorController.jogada(jogador)) {
                utils.limparTerminal();
                utils.mostrarMensagem("O jogador " + jogador.getNome() + " tirou dados iguais.\nPode jogar os dados novamente.");
                utils.pausar();

                jogadorController.jogada(jogador);
            }

        } else if (modoDeJogo == 2) {
            // Modo Debug: permite que o jogador escolha a casa que deseja ir
            while (looping) {
                utils.limparTerminal();
                utils.mostrarMensagem("Jogador: " + jogador.getNome() + " - Casa: " + jogador.getNumeroAtualDaCasa());
                valorDaCasa = menuView.lerValorDaCasa();

                if (valorDaCasa >= 1 && valorDaCasa <= 40) { looping = false; }

                if (jogador.getNumeroAtualDaCasa() < valorDaCasa) {
                    diferenca = valorDaCasa - jogador.getNumeroAtualDaCasa();

                    jogador.pularCasas(diferenca);
                } else {
                    diferenca = jogador.getNumeroAtualDaCasa() - valorDaCasa;

                    jogador.voltarCasas(diferenca);
                }

                utils.mostrarMensagem("\nO jogador " + jogador.getNome() + " foi para a casa " + jogador.getNumeroAtualDaCasa());
                utils.pausar();
            }
        }
    }
}