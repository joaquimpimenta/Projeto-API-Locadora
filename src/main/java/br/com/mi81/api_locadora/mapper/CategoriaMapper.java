package br.com.mi81.api_locadora.mapper;

import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaRequestDTO;
import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaResponseDTO;
import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Categoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {
    /**
     * Converte dados de criação para uma entidade categoria.
     * @param requestDTO dados recebidos para criação
     * @return entidade categoria
     */
    public Categoria toEntity(CategoriaRequestDTO requestDTO){
        return Categoria.builder()
                .nome(requestDTO.nome())
                .build();
    }

    /**
     * Converte uma entidade categoria para o DTO de resposta.
     * @param categoria entidade persistida
     * @return representação pública categoria.
     */

    public CategoriaResponseDTO toResponse(Categoria categoria){
        return new CategoriaResponseDTO(
                categoria.getCategoria_id(),
                categoria.getNome(),
                categoria.getUltima_atualizacao());
    }

    /**
     * Converte uma lista de Entidades para uma lista de DTOs de resposta
     */
    public List<CategoriaResponseDTO> toResponseList(List<Categoria> categorias){
        return categorias.stream().map(this::toResponse).toList();
    }

    public void updateEntity(CategoriaUpdateRequestDTO requestDTO, Categoria categoria){
        categoria.setNome(requestDTO.nome());
    }

}
