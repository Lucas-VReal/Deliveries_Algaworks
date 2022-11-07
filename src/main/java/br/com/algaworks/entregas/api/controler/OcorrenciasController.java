package br.com.algaworks.entregas.api.controler;

import br.com.algaworks.entregas.api.Mapper.OcorrenciaMapper;
import br.com.algaworks.entregas.api.Model.OcorrenciaModel;
import br.com.algaworks.entregas.api.Model.input.OcorrenciaInput;
import br.com.algaworks.entregas.domain.model.Ocorrencia;
import br.com.algaworks.entregas.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciasController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrarOcorrencia (@PathVariable Long entregaId,
                                                @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrencia =  registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
        return ocorrenciaMapper.toModel(ocorrencia);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OcorrenciaModel> buscarOcorrencias(@PathVariable Long entregaId){
        return registroOcorrenciaService.buscarOcorrencias(entregaId);
    }

}
