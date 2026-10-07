package src.menu;

import src.exceptions.EntradaInvalidaException;

public class Menu {
    private MenuController controller = new MenuController();
    private int opcao;
    private boolean looping = true;

    public Menu () {

    }

    public void menu () throws EntradaInvalidaException{
        do {
            opcao = controller.menu();

            switch (opcao) {
                case 1:
                    opcao = controller.menuDeModoDeJogo();

                    while (looping) {
                        switch (opcao) {
                            case 1:
                                controller.iniciarJogo(opcao);
                                looping = false;
                                break;

                            case 2:
                                controller.iniciarJogo(opcao);
                                looping = false;
                                break;

                            case 3:
                                looping = false;
                                break;

                            default:
                                continue;
                        }
                    }

                    looping = true;
                    break;

                case 2:
                    controller.criarJogador();
                    break;

                case 3:
                    looping = false;
                    controller.sair();
                    break;
                default:
                    continue;
            }
        } while (looping);
    }
}
