package src.casa;

import java.util.List;
import java.util.ArrayList;
import src.jogador.Jogador;

public class CasaController {
    private List<Casa> casas = new ArrayList<>();
    private int QUANTIDADE_DE_CASAS = 40;

    public CasaController () {}

    public List<Casa> criarCasas () {
        for (int i = 1; i <= QUANTIDADE_DE_CASAS; i++) {
            if (i == 5 || i == 15 || i == 30) {
                casas.add(new CasaDaSorte(i));
                continue;
            }

            if (i == 20 || i == 35) {
                casas.add(new CasaMagica(i));
                continue;
            }

            if (i == 13) {
                casas.add(new CasaSurpresa(i));
                continue;
            }

            casas.add(new Casa(i));
        }

        return casas;
    }

    public void acaoDasCasas (List<Casa> casas, List<Jogador> jogadores, Jogador jogador) {
        for (Casa casa : casas ) {
            if (jogador.getNumeroAtualDaCasa() == casa.getNumeroDaCasa()) {
                casa.funcaoEspecial(jogadores, jogadores.indexOf(jogador));

                utils.mostrarMensagem("Você caiu na casa ")
            }
        }
    }
}
