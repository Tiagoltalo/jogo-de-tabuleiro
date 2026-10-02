package src.menu;

public class Menu {
    private MenuController controller = new MenuController();
    private int opcao;
    private boolean looping = true;

    public Menu () {

    }

    public void menu () {
        do {
            opcao = controller.menu();

            switch (opcao) {
                case 1:
                    controller.iniciarJogo();
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
