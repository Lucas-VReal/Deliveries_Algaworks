package br.com.algaworks.entregas.api.Model.input;

import br.com.algaworks.entregas.api.Model.DestinatarioModel;
import br.com.algaworks.entregas.domain.enums.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DestinatarioInput {

    @NotBlank
    private BigDecimal taxa;
    @NotBlank
    private DestinatarioModel destinatario;
    @NotBlank
    private StatusEntrega status;
    @NotBlank
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

}
