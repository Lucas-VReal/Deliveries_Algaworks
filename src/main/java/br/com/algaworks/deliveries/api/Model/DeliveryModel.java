package br.com.algaworks.deliveries.api.Model;

import br.com.algaworks.deliveries.domain.enums.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryModel {

    private long id;
//    private String idClient;
//    private String nomeClient;
    private ClientResumModel client;
    private BigDecimal taxa;
    private RecipientModel recipient;
    private DeliveryStatus status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;


}
