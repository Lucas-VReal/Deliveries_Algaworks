package br.com.algaworks.entregas.api;

import br.com.algaworks.entregas.domain.model.Clientes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/clientes")
    public List<Clientes> listar(){
        var cliente1 = new Clientes();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setEmail("joão@gmail.com");
        cliente1.setTelefone("9999-8888");

        var cliente2 = new Clientes();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria@gmail.com");
        cliente2.setTelefone("7777-8888");

        return Arrays.asList(cliente1, cliente2);
    }
}
