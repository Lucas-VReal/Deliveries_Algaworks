package br.com.algaworks.entregas.api.Model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaInput {

    @Valid
    @NotNull
    private ClienteIdInput cliente;
    @Valid
    @NotNull
    private DestinatarioInput destinatario;

    private BigDecimal taxa;

}
