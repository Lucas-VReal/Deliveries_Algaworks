package br.com.algaworks.deliveries.domain.model;

import br.com.algaworks.deliveries.domain.enums.DeliveryStatus;
import br.com.algaworks.deliveries.domain.exceptions.BusinessException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal taxa;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;

    @ManyToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Embedded //Abstrai os dados do destinatário para uma única tabela
    private Recipient recipient;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();


    public Occurrence adicionarOcorrencia(String descricao) {
        var novaOcorrencia = new Occurrence();
        novaOcorrencia.setDescricao(descricao);
        novaOcorrencia.setDataRegistro(OffsetDateTime.now());
        novaOcorrencia.setDelivery(this);

        this.getOccurrences().add(novaOcorrencia);
        return novaOcorrencia;
    }

    public void finalizar(Delivery delivery) {

        if(!podeSerFinalizada(delivery)) {
            throw new BusinessException("A Entrega não está pendente");
        }
        delivery.setStatus(DeliveryStatus.FINALIZADA);
    }

    private boolean podeSerFinalizada(Delivery delivery) {
        return delivery.getStatus().equals(DeliveryStatus.PENDENTE);
    }

    public void cancelar(Delivery delivery) {
        if(!podeSerFinalizada(delivery)) {
            throw new BusinessException("A Entrega não está pendente");
        }
        delivery.setStatus(DeliveryStatus.CANCELADA);
    }
}
