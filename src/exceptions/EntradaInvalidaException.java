package src.exceptions;

public class EntradaInvalidaException extends Exception {
    private final String campo;
    private final String valorDigitado;

    public EntradaInvalidaException (String campo, String valorDigitado, String motivo) {
        super(String.format("Valor inválido para '%s':%s.", campo, motivo));
        this.campo = campo;
        this.valorDigitado = valorDigitado;
    }

    public EntradaInvalidaException (String campo, String valorDigitado, String motivo, Throwable causa) {
        super(String.format("Valor inválido para '%s':%s", campo, motivo), causa);
        this.campo = campo;
        this.valorDigitado = valorDigitado;
    }

    public String getCampo () { return campo; }

    public String getValorDigitado () { return valorDigitado; }
}
