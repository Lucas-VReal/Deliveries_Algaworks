package br.com.algaworks.deliveries.api.Model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryInput {

        @Valid
        @NotNull
        private ClientInput cliente;

        @Valid
        @NotNull
        private RecipientInput recipient;

        @NotNull
        private BigDecimal taxa;

}
