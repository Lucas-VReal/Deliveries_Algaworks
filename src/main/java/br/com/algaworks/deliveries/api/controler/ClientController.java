package br.com.algaworks.deliveries.api.controler;

import br.com.algaworks.deliveries.domain.model.Client;
import br.com.algaworks.deliveries.domain.repository.ClientRepository;

import br.com.algaworks.deliveries.domain.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor //cria os construtores automaticamente
@RestController
@RequestMapping("/clients")
@Api(value = "API REST clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private ClientRepository clientRepository;
    private ClientService clientService;

    @GetMapping
    @ApiOperation(value= "List all clients")
    public List<Client> listar(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value= "find a Client by Id")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return clientRepository.findById(id)
//                .map(client -> ResponseEntity.ok(client))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        Optional<client> clientOptional = clientRepository.findById(id);
//
//        if(clientOptional.isPresent()){
//            return ResponseEntity.ok(clientOptional.get());
//        }
//
//        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value= "create a new client")
    public Client addNewClient (@Valid @RequestBody Client client){
        return clientService.salvar(client);
    }

    @PutMapping("/{id}")
    @ApiOperation(value= "Update a client by Id")
    public ResponseEntity<Client> updateAClient (@PathVariable Long id, @Valid @RequestBody Client client){
        if(!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        clientService.salvar(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value= "Delete a client")
    public ResponseEntity<Void> DeleteById(@PathVariable Long id){
        if(!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clientService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
