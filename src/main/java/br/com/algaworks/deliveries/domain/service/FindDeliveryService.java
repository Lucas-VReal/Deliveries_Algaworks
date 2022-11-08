package br.com.algaworks.deliveries.domain.service;

import br.com.algaworks.deliveries.domain.exceptions.EntityNotFound;
import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery findDelivery(Long deliveryId){
            Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFound("Entrega não encontrada"));

            return delivery;
    }


}
