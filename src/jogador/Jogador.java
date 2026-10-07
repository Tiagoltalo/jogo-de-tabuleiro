package src.jogador;

import java.util.Random;

public class Jogador {
    protected String nome;
    protected String cor;
    protected String tipo;
    protected int numeroDaCasaAtual;
    protected Random random = new Random();

    public Jogador (String nome, String cor, String tipo) {
        this.nome = nome;
        this.cor = cor;
        this.tipo = tipo;
        this.numeroDaCasaAtual = 0;
    };

    public int[] jogarDados () {
        int dado1 = random.nextInt(1, 6);
        int dado2 = random.nextInt(1, 6);
        int resultado = dado1 + dado2;
        int jogarDadosNovamente = 0;

        if (dado1 == dado2) {
            jogarDadosNovamente = 1;
        }

        return new int[] {resultado, jogarDadosNovamente};
    }

    public void pularCasas (int quantidadeDeCasas) {
        if (quantidadeDeCasas < 0) {
            System.out.print("\nAtenção!!! Ocorreu um erro no programa, jogue os dados novamente.");
        } else {
            this.numeroDaCasaAtual += quantidadeDeCasas;
        }
    }

    public void voltarCasas (int quantidadeDeCasas) {
        if (quantidadeDeCasas < 0) {
            System.out.print("\nAtenção!!! Ocorreu um erro no programa, jogue os dados novamente.");
        } else {
            this.numeroDaCasaAtual -= quantidadeDeCasas;
        }
    }

    public String getNome () {
        return this.nome;
    }

    public String getCor () {
        return this.cor;
    }

    public String getTipo () {
        return this.tipo;
    }

    public int getNumeroAtualDaCasa () {
        return this.numeroDaCasaAtual;
    }
}