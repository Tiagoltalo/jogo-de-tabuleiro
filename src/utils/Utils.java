package src.utils;

import java.util.Scanner;

public class Utils {
    private Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_VERMELHO = "\u001B[31m";
    public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_AMARELO = "\u001B[33m";
    public static final String ANSI_AZUL = "\u001B[34m";
    public static final String ANSI_ROXO = "\u001B[35m";
    public static final String ANSI_BRANCO = "\u001B[37m";

    public Utils () {

    }

    public String aplicarCor (String texto, String cor) {
        String textoComCor;

        switch (cor) {
            case "vermelho": textoComCor = ANSI_VERMELHO + texto + ANSI_RESET; break;
            case "verde": textoComCor = ANSI_VERDE + texto + ANSI_RESET; break;
            case "amarelo": textoComCor = ANSI_AMARELO + texto + ANSI_RESET; break;
            case "azul": textoComCor = ANSI_AZUL + texto + ANSI_RESET; break;
            case "roxo": textoComCor = ANSI_ROXO + texto + ANSI_RESET; break;
            case "branco": textoComCor = ANSI_BRANCO + texto + ANSI_RESET; break;
            default:
                textoComCor = texto;
        }

        return textoComCor;
    }

    public void mostrarMensagem (String mensagem) {
        System.out.print(mensagem);
    }

    public void pausar () {
        System.out.print("\nPressione Enter...");
        scanner.nextLine();
    }

    public void limparTerminal () {
        System.out.print("\033c");
    }
}
