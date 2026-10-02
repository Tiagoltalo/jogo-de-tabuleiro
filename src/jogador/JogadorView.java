package src.jogador;

import java.util.Scanner;
import java.util.List;

public class JogadorView {
    Scanner scanner = new Scanner(System.in);
    private String texto;
    private int numero;

    public JogadorView () {}

    public String lerNome () {
        System.out.print("Digite o nome do jogador: ");
        texto = scanner.next();
        
        try {
            return texto.toLowerCase();
        } catch (Exception e) {
            System.out.print("\nPor favor, digite um valor válido.");
        }

        return null;
    }

    public String lerCor () {
        System.out.print("Digite a cor do jogador: ");
        texto = scanner.next();

        try {
            return texto.toLowerCase();
        } catch (Exception e) {
            System.out.print("\nPor favor, digite um valor válido.");
        }

        return null;
    }

    public String lerTipo () {
        System.out.print("\n[ 1 ] Jogador Normal\n");
        System.out.print("[ 2 ] Jogador Sortudo\n");
        System.out.print("[ 3 ] Jogador Azarado\n");
        System.out.print("\nEscolha o tipo do seu jogador: ");
        
        try {
            numero = scanner.nextInt();

            if (numero == 1) {
                texto = "jogadornormal";
            } else if (numero == 2) {
                texto = "jogadorsortudo";
            } else if (numero == 3) {
                texto = "jogadorazarado";
            }

            return texto;
        } catch (Exception e) {
            System.out.print("\nPor favor, digite um valor válido.");
        }

        return null;
    }

    public void imprimirJogadores (List<Jogador> jogadores) {
        System.out.print("\n");

        for (Jogador jogador : jogadores) {
            System.out.print("| Jogador: " + jogador.getNome() + " - Casa: " + jogador.getNumeroAtualDaCasa() + " ");
        }

        System.out.print("|\n");
    }
}
