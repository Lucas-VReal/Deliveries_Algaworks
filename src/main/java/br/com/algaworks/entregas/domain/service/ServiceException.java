package br.com.algaworks.entregas.domain.service;

public class ServiceException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public ServiceException (String message){
        super(message);
    }
}
