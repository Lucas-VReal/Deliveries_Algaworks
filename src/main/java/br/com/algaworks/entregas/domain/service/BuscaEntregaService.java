package br.com.algaworks.entregas.domain.service;

import br.com.algaworks.entregas.domain.exceptions.EntidadeNaoEncontradaException;
import br.com.algaworks.entregas.domain.model.Entrega;
import br.com.algaworks.entregas.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public  Entrega buscarEntrega(Long entregaId){
            Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));

            return entrega;
    }


}
