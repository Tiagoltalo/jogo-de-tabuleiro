package src.exceptions;

public interface LeituraValidada<T> {
    T ler() throws EntradaInvalidaException;
}
