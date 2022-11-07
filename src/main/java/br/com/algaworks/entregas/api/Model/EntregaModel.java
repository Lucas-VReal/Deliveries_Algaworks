package br.com.algaworks.entregas.api.Model;

import br.com.algaworks.entregas.domain.enums.StatusEntrega;
import br.com.algaworks.entregas.domain.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaModel {

    private long id;
//    private String idCliente;
//    private String nomeCliente;
    private ClienteResumoModel cliente;
    private BigDecimal taxa;
    private DestinatarioModel destinatario;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;


}
