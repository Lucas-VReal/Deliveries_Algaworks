package br.com.algaworks.deliveries.domain.service;

import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class FinishingDeliveryService {

    private FindDeliveryService findDeliveryService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void finalizarEntrega (Long entregaId){
        Delivery delivery = findDeliveryService.findDelivery(entregaId);
        delivery.finalizar(delivery);
        delivery.setDataFinalizacao(OffsetDateTime.now());
        deliveryRepository.save(delivery);
    }
}
