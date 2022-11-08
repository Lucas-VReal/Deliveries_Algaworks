package br.com.algaworks.deliveries.api.controler;

import br.com.algaworks.deliveries.api.Mapper.OccurrenceMapper;
import br.com.algaworks.deliveries.api.Model.OccurrenceModel;
import br.com.algaworks.deliveries.api.Model.input.OccurrenceInput;
import br.com.algaworks.deliveries.domain.model.Occurrence;
import br.com.algaworks.deliveries.domain.service.RegistroOcorrenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrencies")
@Api(value = "API REST Ocorrencias")
@CrossOrigin(origins = "*")
public class OccurrencesController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OccurrenceMapper occurrenceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value= "register an occurrence. Nedeed: deliveryId and description")
    public OccurrenceModel registrarOcorrencia (@PathVariable Long deliveryId,
                                               @Valid @RequestBody OccurrenceInput occurrenceInput){
        Occurrence occurrence =  registroOcorrenciaService.registrar(deliveryId, occurrenceInput.getDescricao());
        return occurrenceMapper.toModel(occurrence);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value= "Get all ocurrencies by deliveryId")
    public List<OccurrenceModel> buscarOcorrencias(@PathVariable Long deliveryId){
        return registroOcorrenciaService.buscarOcorrencias(deliveryId);
    }

}
