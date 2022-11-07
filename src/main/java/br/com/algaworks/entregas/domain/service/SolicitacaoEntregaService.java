package br.com.algaworks.entregas.domain.service;

import br.com.algaworks.entregas.domain.enums.StatusEntrega;
import br.com.algaworks.entregas.domain.model.Cliente;
import br.com.algaworks.entregas.domain.model.Entrega;
import br.com.algaworks.entregas.domain.repository.ClienteRepository;
import br.com.algaworks.entregas.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega){

        entrega.setCliente(clienteService.findClientById(entrega.getCliente().getId()));
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);

    }
}
