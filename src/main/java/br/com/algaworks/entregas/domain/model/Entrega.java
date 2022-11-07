package br.com.algaworks.entregas.domain.model;

import br.com.algaworks.entregas.domain.enums.StatusEntrega;
import br.com.algaworks.entregas.domain.exceptions.NegocioException;
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
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal taxa;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @Embedded //Abstrai os dados do destinatário para uma única tabela
    private Destinatario destinatario;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<>();


    public Ocorrencia adicionarOcorrencia(String descricao) {
        var novaOcorrencia = new Ocorrencia();
        novaOcorrencia.setDescricao(descricao);
        novaOcorrencia.setDataRegistro(OffsetDateTime.now());
        novaOcorrencia.setEntrega(this);

        this.getOcorrencias().add(novaOcorrencia);
        return novaOcorrencia;
    }

    public void finalizar(Entrega entrega) {

        if(!podeSerFinalizada(entrega)) {
            throw new NegocioException("A Entrega não está pendente");
        }
        entrega.setStatus(StatusEntrega.FINALIZADA);
    }

    private boolean podeSerFinalizada(Entrega entrega) {
        return entrega.getStatus().equals(StatusEntrega.PENDENTE);
    }

    public void cancelar(Entrega entrega) {
        if(!podeSerFinalizada(entrega)) {
            throw new NegocioException("A Entrega não está pendente");
        }
        entrega.setStatus(StatusEntrega.CANCELADA);
    }
}
