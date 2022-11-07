package br.com.algaworks.entregas.domain.service;

import br.com.algaworks.entregas.api.Mapper.EntregaMapper;
import br.com.algaworks.entregas.api.Mapper.OcorrenciaMapper;
import br.com.algaworks.entregas.api.Model.OcorrenciaModel;
import br.com.algaworks.entregas.domain.exceptions.NegocioException;
import br.com.algaworks.entregas.domain.model.Entrega;
import br.com.algaworks.entregas.domain.model.Ocorrencia;
import br.com.algaworks.entregas.domain.repository.EntregaRepository;
import br.com.algaworks.entregas.domain.repository.OcorrenciasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private OcorrenciaMapper ocorrenciaMapper;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscarEntrega(entregaId);

        return entrega.adicionarOcorrencia(descricao);

    }

    public List<OcorrenciaModel> buscarOcorrencias(Long entregaId){
        Entrega entrega = buscaEntregaService.buscarEntrega(entregaId);

        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
    }

}
