package br.com.algaworks.deliveries.api.ApiExceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL) //NÃO MOSTRA ELEMENTO NULO
@Getter
@Setter
public class Problem {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;


    @Data
    @AllArgsConstructor
    public static class Campo {
        private String nome;
        private String mensagem;

    }
}
