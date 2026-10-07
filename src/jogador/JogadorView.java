package src.jogador;

import java.util.Scanner;
import java.util.List;
import src.exceptions.EntradaInvalidaException;

public class JogadorView {
    Scanner scanner = new Scanner(System.in);

    public JogadorView () {}

    public String lerNome () throws EntradaInvalidaException {
        System.out.print("Digite o nome do jogador: ");
        String texto = scanner.nextLine().trim();
        
        if (texto.isEmpty()) {
            throw new EntradaInvalidaException("nome", texto, "o campo não pode ficar vazio");
        }

        return texto.toLowerCase();
    }

    public String lerCor () throws EntradaInvalidaException {
        System.out.print("\n[ 1 ] verde\n");
        System.out.print("[ 2 ] azul\n");
        System.out.print("[ 3 ] vermelho\n");
        System.out.print("[ 4 ] roxo\n");
        System.out.print("[ 5 ] amarelo\n");
        System.out.print("[ 6 ] branco\n");
        System.out.print("\nDigite a cor do jogador: ");
        String texto = scanner.nextLine().trim();
        int opcao;

        try {
            opcao = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("tipo", texto, "digite apenas o número da opção", e);
        }

        switch (opcao) {
            case 1: return "verde";
            case 2: return "azul";
            case 3: return "vermelho";
            case 4: return "roxo";
            case 5: return "amarelo";
            case 6: return "branco";

            default:
                throw new EntradaInvalidaException("cor", texto, "só é possível selecionar opcões de 1-6");
        }
    }

    public String lerTipo () throws EntradaInvalidaException {
        System.out.print("\n[ 1 ] Jogador Normal\n");
        System.out.print("[ 2 ] Jogador Sortudo\n");
        System.out.print("[ 3 ] Jogador Azarado\n");
        System.out.print("\nEscolha o tipo do seu jogador: ");
        String texto = scanner.nextLine().trim();
        int opcao;
        
        try {
            opcao = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("tipo", texto, "digite apenas o número da opção", e);
        }

        switch (opcao) {
            case 1: return "jogadornormal";
            case 2: return "jogadorsortudo";
            case 3: return "jogadorazarado";
            
            default:
                throw new EntradaInvalidaException("tipo", texto, "só é possível escolher entre 1-3");
        }
    }

    public void imprimirJogadores (List<Jogador> jogadores) {
        System.out.print("\n");

        for (Jogador jogador : jogadores) {
            System.out.print("| Jogador: " + jogador.getNome() + " - Casa: " + jogador.getNumeroAtualDaCasa() + " ");
        }

        System.out.print("|\n");
    }
}
