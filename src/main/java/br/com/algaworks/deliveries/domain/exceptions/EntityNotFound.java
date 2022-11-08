package br.com.algaworks.deliveries.domain.exceptions;

public class EntityNotFound extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntityNotFound(String message) {
        super(message);
    }


}
