package br.com.algaworks.entregas.api.controler;

import br.com.algaworks.entregas.domain.model.Cliente;
import br.com.algaworks.entregas.domain.repository.ClienteRepository;

import br.com.algaworks.entregas.domain.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor //cria os construtores automaticamente
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return clienteRepository.findById(id)
//                .map(cliente -> ResponseEntity.ok(cliente))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
//
//        if(clienteOptional.isPresent()){
//            return ResponseEntity.ok(clienteOptional.get());
//        }
//
//        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente addNewClient (@Valid @RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateAClient (@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long id){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
