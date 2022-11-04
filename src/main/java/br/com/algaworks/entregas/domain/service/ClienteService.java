package br.com.algaworks.entregas.domain.service;

import br.com.algaworks.entregas.domain.model.Cliente;
import br.com.algaworks.entregas.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar (Cliente newClient){
        boolean emailEmUso = clienteRepository.findClienteByEmail(newClient.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(newClient));

        if(emailEmUso){
            throw new ServiceException("Já existe cliente cadastrado com esse e-mail");
        }

        return clienteRepository.save(newClient);
    }

    @Transactional
    public void excluir (Long id){
        clienteRepository.deleteById(id);
    }

}
