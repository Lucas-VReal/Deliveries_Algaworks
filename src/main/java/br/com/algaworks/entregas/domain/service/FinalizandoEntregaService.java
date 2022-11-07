package br.com.algaworks.entregas.domain.service;

import br.com.algaworks.entregas.api.ApiExceptions.ApiExceptionHandler;
import br.com.algaworks.entregas.api.ApiExceptions.Problema;
import br.com.algaworks.entregas.domain.enums.StatusEntrega;
import br.com.algaworks.entregas.domain.exceptions.EntidadeNaoEncontradaException;
import br.com.algaworks.entregas.domain.exceptions.NegocioException;
import br.com.algaworks.entregas.domain.model.Entrega;
import br.com.algaworks.entregas.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class FinalizandoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizarEntrega (Long entregaId){
        Entrega entrega = buscaEntregaService.buscarEntrega(entregaId);
        entrega.finalizar(entrega);
        entrega.setDataFinalizacao(OffsetDateTime.now());
        entregaRepository.save(entrega);
    }
}
