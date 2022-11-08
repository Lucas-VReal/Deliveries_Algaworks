package br.com.algaworks.deliveries.domain.service;

import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class CancelDeliveryService {

    private FindDeliveryService findDeliveryService;
    private DeliveryRepository deliveryRepository;

    public void cancelarEntrega(Long entregaId){
        Delivery deliveryCancelada = findDeliveryService.findDelivery(entregaId);
        deliveryCancelada.cancelar(deliveryCancelada);
        deliveryCancelada.setDataFinalizacao(OffsetDateTime.now());
        deliveryRepository.save(deliveryCancelada);
    }
}
