package br.com.algaworks.deliveries.api.controler;

import br.com.algaworks.deliveries.api.Mapper.DeliveryMapper;
import br.com.algaworks.deliveries.api.Model.DeliveryModel;
import br.com.algaworks.deliveries.api.Model.input.DeliveryInput;
import br.com.algaworks.deliveries.domain.model.Delivery;
import br.com.algaworks.deliveries.domain.repository.DeliveryRepository;
import br.com.algaworks.deliveries.domain.service.CancelDeliveryService;
import br.com.algaworks.deliveries.domain.service.FinishingDeliveryService;
import br.com.algaworks.deliveries.domain.service.SolicitacaoEntregaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
@Api(value = "API REST Deliveries")
@CrossOrigin(origins = "*")
public class DeliveryController {

    private SolicitacaoEntregaService deliveryService;
    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    private FinishingDeliveryService finalizandoDeliveryService;
    private CancelDeliveryService cancelandoDeliveryService;

    @GetMapping
    @ApiOperation(value= "List all deliveries")
    public List<DeliveryModel> getAllDeliveries(){
        List<Delivery> delivery = deliveryRepository.findAll();
        return deliveryMapper.toCollectionModel(delivery);
    }

    @GetMapping("/{id}")
    @ApiOperation(value= "Find a delivery by Id")
    public ResponseEntity<DeliveryModel> findOneById(@PathVariable Long id){
        return deliveryRepository.findById(id)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value= "request a new delivery. Needed: Client Id and taxa and destinatario+StatusDelivery+ataPedido+dataFinalizacao")
    public DeliveryModel solicitarNovaDelivery (@Valid @RequestBody DeliveryInput deliveryInput){
        Delivery novaDelivery = deliveryMapper.toEntity(deliveryInput);
        System.out.println(novaDelivery);
        deliveryRepository.save(novaDelivery);
        return deliveryMapper.toModel(novaDelivery);
    }


    @PutMapping("/{deliveryId}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value= "finish the delivery by Id")
    public void finalizarDelivery(@PathVariable Long deliveryId){
        finalizandoDeliveryService.finalizarEntrega(deliveryId);
    }

    @PutMapping("/{deliveryId}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value= "Cancel a delivery by Id")
    public void cancelarDelivery(@PathVariable Long deliveryId){
        cancelandoDeliveryService.cancelarEntrega(deliveryId);
    }

}
