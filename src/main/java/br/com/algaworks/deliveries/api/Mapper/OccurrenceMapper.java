package br.com.algaworks.deliveries.api.Mapper;

import br.com.algaworks.deliveries.api.Model.OccurrenceModel;
import br.com.algaworks.deliveries.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceModel toModel(Occurrence occurrence){
        return modelMapper.map(occurrence, OccurrenceModel.class);
    }

    public List<OccurrenceModel> toCollectionModel(List<Occurrence> occurrences){
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
