package br.com.algaworks.deliveries.domain.service;

import br.com.algaworks.deliveries.domain.enums.DeliveryStatus;
import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    @Transactional
    public Delivery solicitar(Delivery delivery){

        delivery.setClient(clientService.findClientById(delivery.getClient().getId()));
        delivery.setStatus(DeliveryStatus.PENDENTE);
        delivery.setDataPedido(OffsetDateTime.now());

        return deliveryRepository.save(delivery);

    }
}
