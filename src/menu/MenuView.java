package src.menu;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);
    private int opcao;

    public MenuView () {

    }

    public void imprimirMenu () {
        System.out.println("""
                ╔══════════════════════════════════════╗
                ║           JOGO DE TABULEIRO          ║
                ╠══════════════════════════════════════╣
                ║  1. Iniciar Jogo                     ║
                ║  2. Criar Jogador                    ║
                ║  3. Sair                             ║
                ╚══════════════════════════════════════╝
                """);
    }

    public int lerOpcao () {
        System.out.print("\nDigite a opção deseja: ");
        
        try {
            opcao = scanner.nextInt();
            return opcao;
        } catch (Exception e) {
            System.out.print("\nPor favor, digite um valor válido.");
        }

        return 0;
    }
}
