package br.com.algaworks.entregas.domain.exceptions;

public class EntidadeNaoEncontradaException extends NegocioException{

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }


}
