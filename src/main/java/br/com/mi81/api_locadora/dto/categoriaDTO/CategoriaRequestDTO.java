package br.com.mi81.api_locadora.dto.categoriaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Dados necessários para cadastrar uma novo categoria
 * @param nome nome da categoria
 */
@Schema(description = "Dados utilizados para cadastrar um produto")
public record CategoriaRequestDTO (
        @NotNull(message = "O nome é obrigatório")
        String nome
) {}
