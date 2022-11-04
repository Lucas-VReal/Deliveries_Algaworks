package br.com.algaworks.entregas.api.exceptions;

import br.com.algaworks.entregas.domain.service.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problema.Campo> campos = new ArrayList<>();


        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            //String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale()); para usar o messages.properties
            String mensagem = error.getDefaultMessage();
            campos.add(new Problema.Campo(nome, mensagem));
        }


        var problema = new Problema();

            problema.setStatus(status.value());
            problema.setDataHora(LocalDateTime.now());
            problema.setTitulo("Um ou mais campos inválidos");
            problema.setCampos(campos);

        return handleExceptionInternal(ex, problema, headers, status, request);

    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException (ServiceException ex, WebRequest webRequest){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        var problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(LocalDateTime.now());
        problema.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, webRequest);

    }
}
