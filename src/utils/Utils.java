package src.utils;

import java.util.Scanner;

public class Utils {
    private Scanner scanner = new Scanner(System.in);

    public Utils () {

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
