package src.jogador;

public class JogadorSortudo extends Jogador {
    public JogadorSortudo (String nome, String cor) {
        super(nome, cor, "jogadorsortudo");
    }

    @Override 
    public int[] jogarDados () {
        int dado1;
        int dado2;
        int resultado;
        int jogarDadosNovamente = 0;

        while(true) {
            dado1 = random.nextInt(1, 6);
            dado2 = random.nextInt(1, 6);
            resultado = dado1 + dado2;

            if (resultado >= 7) {
                if (dado1 == dado2) {
                    jogarDadosNovamente = 0;
                }
                return new int[] {resultado, jogarDadosNovamente};
            }
        }
    }
}
