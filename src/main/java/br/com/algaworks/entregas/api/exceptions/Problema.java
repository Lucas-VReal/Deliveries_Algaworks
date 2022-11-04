package br.com.algaworks.entregas.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL) //NÃO MOSTRA ELEMENTO HNULO
@Getter
@Setter
public class Problema {
    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;


    @Data
    @AllArgsConstructor
    public static class Campo {
        private String nome;
        private String mensagem;

    }
}
