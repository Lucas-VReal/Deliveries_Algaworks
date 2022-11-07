package br.com.algaworks.entregas.api.controler;

import br.com.algaworks.entregas.api.Mapper.EntregaMapper;
import br.com.algaworks.entregas.api.Model.EntregaModel;
import br.com.algaworks.entregas.api.Model.input.EntregaInput;
import br.com.algaworks.entregas.api.Model.input.OcorrenciaInput;
import br.com.algaworks.entregas.domain.model.Entrega;
import br.com.algaworks.entregas.domain.model.Ocorrencia;
import br.com.algaworks.entregas.domain.repository.EntregaRepository;
import br.com.algaworks.entregas.domain.service.CancelandoEntregaService;
import br.com.algaworks.entregas.domain.service.FinalizandoEntregaService;
import br.com.algaworks.entregas.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService entregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;

    private FinalizandoEntregaService finalizandoEntregaService;
    private CancelandoEntregaService cancelandoEntregaService;

    @GetMapping
    public List<EntregaModel> getAllEntregas (){
        List<Entrega> entregas = entregaRepository.findAll();
        return entregaMapper.toCollectionModel(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaModel> findOneById(@PathVariable Long id){
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitarNovaEntrega (@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
        return entregaMapper.toModel(entregaService.solicitar(novaEntrega));
    }


    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizarEntrega(@PathVariable Long entregaId){
        finalizandoEntregaService.finalizarEntrega(entregaId);
    }

    @PutMapping("/{entregaId}/cancelamento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarEntrega(@PathVariable Long entregaId){
        cancelandoEntregaService.cancelarEntrega(entregaId);
    }

}
