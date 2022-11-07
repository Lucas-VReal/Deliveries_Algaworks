package br.com.algaworks.entregas.api.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaModel {


    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
