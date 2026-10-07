package src;

import src.menu.Menu;

public class Jogo {
    static Menu menu = new Menu();

    public static void main(String[] args) {
        try {
            menu.menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}