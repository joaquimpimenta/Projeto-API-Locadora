package br.com.mi81.api_locadora.mapper;

import br.com.mi81.api_locadora.dto.atorDTO.AtorRequestDTO;
import br.com.mi81.api_locadora.dto.atorDTO.AtorResponseDTO;
import br.com.mi81.api_locadora.dto.atorDTO.AtorUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Ator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtorMapper {

    public Ator toEntity(AtorRequestDTO requestDTO){
        return Ator.builder()
                .primeiro_nome(requestDTO.primeiro_nome())
                .ultimo_nome(requestDTO.ultimo_nome())
                .build();
    }

    public AtorResponseDTO toResponse(Ator ator){
        return new AtorResponseDTO(
                ator.getAtor_id(),
                ator.getPrimeiro_nome(),
                ator.getUltimo_nome(),
                ator.getUltima_atualizacao()
        );
    }

    public List<AtorResponseDTO> toResponseList(List<Ator> atores){
        return atores.stream().map(this::toResponse).toList();
    }

    public void updateEntity(AtorUpdateRequestDTO requestDTO, Ator ator){
        ator.setPrimeiro_nome(requestDTO.primeiro_nome());
        ator.setUltimo_nome(requestDTO.ultimo_nome());
    }

}
