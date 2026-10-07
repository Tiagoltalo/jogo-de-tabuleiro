package src.menu;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);

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

    public void imprimirMenuModoDeJogo () {
        System.out.println("""
                ╔══════════════════════════════════════╗
                ║        ESCOLHA O MODO DE JOGO        ║
                ╠══════════════════════════════════════╣
                ║  1. Modo Normal                      ║
                ║  2. Modo Debug                       ║
                ║  3. Voltar ao Menu Pricipal          ║
                ╚══════════════════════════════════════╝
                """);
    }

    public int lerValorDaCasa () {
        String texto;
        int opcao;

        System.out.print("\nDigite o valor da casa desejada: ");
        texto = scanner.next();

        try {
            opcao = Integer.parseInt(texto);
            return opcao;
        } catch (Exception e) {
            System.out.print("\nPor favor, digite um valor válido.");
        }

        return 0;
    }

    public int lerOpcao () {
        String texto;
        int opcao;

        System.out.print("\nDigite a opção deseja: ");
        texto = scanner.next();
        
        try {
            opcao = Integer.parseInt(texto);
            return opcao;
        } catch (Exception e) {
            System.out.print("\nPor favor, digite um valor válido.");
        }

        return 0;
    }
}
