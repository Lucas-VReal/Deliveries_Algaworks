package br.com.algaworks.deliveries.domain.service;

import br.com.algaworks.deliveries.domain.model.Client;
import br.com.algaworks.deliveries.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public Client salvar (Client newClient){
        boolean emailEmUso = clientRepository.findClientByEmail(newClient.getEmail())
                .stream()
                .anyMatch(clientExistente -> !clientExistente.equals(newClient));

        if(emailEmUso){
            throw new ServiceException("Já existe cliente cadastrado com esse e-mail");
        }

        return clientRepository.save(newClient);
    }

    @Transactional
    public void excluir (Long id){
        clientRepository.deleteById(id);
    }

    public Client findClientById (Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Cliente não encontrado"));
        return client;
    }

}
