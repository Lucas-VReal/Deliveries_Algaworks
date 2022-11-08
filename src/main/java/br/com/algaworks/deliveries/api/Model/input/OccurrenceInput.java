package br.com.algaworks.deliveries.api.Model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInput {

    @NotBlank
    private String descricao;
}
