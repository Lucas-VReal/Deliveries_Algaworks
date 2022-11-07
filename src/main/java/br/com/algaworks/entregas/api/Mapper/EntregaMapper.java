package br.com.algaworks.entregas.api.Mapper;

import br.com.algaworks.entregas.api.Model.EntregaModel;
import br.com.algaworks.entregas.api.Model.input.EntregaInput;
import br.com.algaworks.entregas.domain.model.Entrega;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel) //aqui transforma uma stream de Entregas em uma stream de EntregasModel
                .collect(Collectors.toList()); //transforma stream em um list
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }

}
