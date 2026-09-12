package br.com.mi81.api_locadora.dto.categoriaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

/**
 * Dados utilizados para atualizar completamente a categoria
 * @param nome novo nome da categoria
 */
@Schema(description = "Dados para atualização de uma categoria")
public record CategoriaUpdateRequestDTO (

        @Schema(
                description = "Novo nome da categoria",
                example = "drama"
        )
        @NotNull(message = "O nome da categoria é obrigatório")
        String nome
) {}
