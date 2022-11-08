package br.com.algaworks.deliveries.api.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrenceModel {


    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
