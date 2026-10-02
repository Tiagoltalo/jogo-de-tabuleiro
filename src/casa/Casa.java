package src.casa;

import java.util.List;
import src.jogador.Jogador;

public class Casa {
    protected int numeroDaCasa;

    public Casa (int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String jogadorNaCasa (boolean estaJogador) {
        String peca = "I";

        if (estaJogador) {
            return peca;
        } else {
            return String.valueOf(numeroDaCasa);
        }
    }

    public String funcaoEspecial (List<Jogador> jogador, int indice) { return null; }

    public int getNumeroDaCasa () {
        return this.numeroDaCasa;
    }
}