package br.com.algaworks.deliveries.domain.service;

import br.com.algaworks.deliveries.api.Mapper.OccurrenceMapper;
import br.com.algaworks.deliveries.api.Model.OccurrenceModel;
import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private OccurrenceMapper occurrenceMapper;
    private FindDeliveryService findDeliveryService;

    @Transactional
    public Occurrence registrar(Long entregaId, String descricao){
        Delivery delivery = findDeliveryService.findDelivery(entregaId);

        return delivery.adicionarOcorrencia(descricao);

    }

    public List<OccurrenceModel> buscarOcorrencias(Long entregaId){
        Delivery delivery = findDeliveryService.findDelivery(entregaId);

        return occurrenceMapper.toCollectionModel(delivery.getOccurrences());
    }

}
