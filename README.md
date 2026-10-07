# Trabalho de POO - Jogo de Tabuleiro 🎲
Jogo de tabuleiro para o terminal desenvolvido em Java, com 40 casas, jogadores de tipos diferentes e casas especiais, aplicando herança e polimorfismo nas classes `Jogador` e `Casa`.

## Índice
- [Visão Geral](#visão-geral)
- [Instalação e Execução](#instalação-e-execução)
- [Funcionalidades](#funcionalidades)
- [Como Usar](#como-usar)
- [Estrutura](#estrutura)

## Visão Geral
- Menu Principal (Iniciar Jogo, Criar Jogador e Sair)
- Escolha do Modo de Jogo (Normal ou Debug)
- Criação de Jogadores (Normal, Sortudo e Azarado)
- Tabuleiro 4x10 com 40 casas, colorido por jogador
- Casas Especiais (Sorte, Mágica, Surpresa e Azar)
- Herança e polimorfismo em `Jogador` (Sortudo e Azarado) e `Casa` (Sorte, Mágica e Surpresa)
- Validação de entradas com `EntradaInvalidaException`

## Instalação e Execução
**Requisitos**: JDK ≥ 17 | Windows / Linux / macOS | Terminal com suporte a ANSI

```text
cd jogo-de-tabuleiro

# Linux / macOS
javac -encoding UTF-8 -d bin $(find src -name "*.java")
java -cp bin src.Jogo
```

```text
# Windows (PowerShell)
Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName } > sources.txt
javac -encoding UTF-8 -d bin "@sources.txt"
java -cp bin src.Jogo
```

> O jogo limpa o terminal e usa cores ANSI. No Windows, prefira o Windows Terminal ou o PowerShell.

## Funcionalidades
- Jogadores: cadastrar com nome, cor (verde, azul, vermelho, roxo, amarelo ou branco) e tipo
- Tipos de jogador: **Normal** (dois dados, 2 a 12), **Sortudo** (soma dos dados ≥ 7) e **Azarado** (soma dos dados ≤ 6)
- Dados iguais: o jogador joga novamente na mesma rodada
- Casa da Sorte (5, 15 e 30): pula mais 3 casas, exceto o jogador azarado
- Casa Mágica (20 e 35): troca de lugar com o jogador que está mais atrás
- Casa Surpresa (13): sorteia um novo tipo para o jogador (sortudo, normal ou azarado)
- Casa do Azar (10, 25 e 38): o jogador perde a próxima rodada
- Modo Debug: o jogador escolhe a casa para a qual deseja ir (1 a 40)
- Vitória: o primeiro jogador a alcançar a casa 40 vence
- Validação de nome, cor e tipo: a leitura é repetida até a entrada ser válida

## Como usar
### Criar Jogador
> **Nome**: Tiago<br>
> **Cor**: [ 2 ] azul<br>
> **Tipo**: [ 2 ] Jogador Sortudo<br>

### Iniciar Jogo
> **Requisito**: ao menos 2 jogadores, de tipos diferentes<br>
> **Modo**: [ 1 ] Modo Normal<br>
> **Jogada**: pressione Enter para lançar os dados e acompanhe o tabuleiro a cada rodada<br>

### Entrada Inválida
> **Cor**: 9<br>
> **Resultado**: Valor inválido para 'cor': só é possível selecionar opcões de 1-6. A leitura é repetida.<br>

## Estrutura

```text
jogo-de-tabuleiro/
├── src/
│   ├── Jogo.java
│   ├── casa/
│   │   ├── Casa.java
│   │   ├── CasaController.java
│   │   ├── CasaDaSorte.java
│   │   ├── CasaMagica.java
│   │   └── CasaSurpresa.java
│   ├── exceptions/
│   │   ├── EntradaInvalidaException.java
│   │   └── LeituraValidada.java
│   ├── jogador/
│   │   ├── Jogador.java
│   │   ├── JogadorAzarado.java
│   │   ├── JogadorController.java
│   │   ├── JogadorSortudo.java
│   │   └── JogadorView.java
│   ├── menu/
│   │   ├── Menu.java
│   │   ├── MenuController.java
│   │   └── MenuView.java
│   ├── tabuleiro/
│   │   ├── Tabuleiro.java
│   │   └── TabuleiroController.java
│   └── utils/
│       └── Utils.java
├── .gitignore
└── README.md
```

## Licença
UECE © 2026 Tiago e Laura