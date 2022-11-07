package br.com.algaworks.entregas.domain.service;

import br.com.algaworks.entregas.domain.model.Entrega;
import br.com.algaworks.entregas.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class CancelandoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    public void cancelarEntrega(Long entregaId){
        Entrega entregaCancelada = buscaEntregaService.buscarEntrega(entregaId);
        entregaCancelada.cancelar(entregaCancelada);
        entregaCancelada.setDataFinalizacao(OffsetDateTime.now());
        entregaRepository.save(entregaCancelada);
    }
}
