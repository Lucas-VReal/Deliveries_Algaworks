package br.com.algaworks.deliveries.api.Mapper;

import br.com.algaworks.deliveries.api.Model.ClientResumModel;
import br.com.algaworks.deliveries.api.Model.DeliveryModel;
import br.com.algaworks.deliveries.api.Model.RecipientModel;
import br.com.algaworks.deliveries.api.Model.input.DeliveryInput;
import br.com.algaworks.deliveries.domain.enums.DeliveryStatus;
import br.com.algaworks.deliveries.domain.model.Client;
import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.model.Recipient;
import br.com.algaworks.deliveries.domain.repository.ClientRepository;
import br.com.algaworks.deliveries.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;
    private ClientService clientService;

    public DeliveryModel toModel(Delivery delivery){
        return modelMapper.map(delivery, DeliveryModel.class);
    }

    public List<DeliveryModel> toCollectionModel(List<Delivery> deliveries){
        return deliveries.stream()
                .map(this::toModel) //aqui transforma uma stream de Entregas em uma stream de EntregasModel
                .collect(Collectors.toList()); //transforma stream em um list
    }

    public Delivery toEntity(DeliveryInput deliveryInput){
        var delivery = new Delivery();

        delivery.setStatus(DeliveryStatus.PENDENTE);
        delivery.setDataPedido(OffsetDateTime.now());
        delivery.setClient(clientService.findClientById(deliveryInput.getCliente().getId()));
        delivery.setRecipient(modelMapper.map(deliveryInput.getRecipient(), Recipient.class));
        delivery.setTaxa(deliveryInput.getTaxa());
        System.out.println(delivery);

        return delivery;
    }

}
