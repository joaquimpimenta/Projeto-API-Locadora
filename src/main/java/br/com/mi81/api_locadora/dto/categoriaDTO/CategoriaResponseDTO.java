package br.com.mi81.api_locadora.dto.categoriaDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Timestamp;

/**
 * Representação pública de uma categoria retornada pela API
 * @param nome nome da categoria
 */
@Schema(description = "Dados de uma categoria retornada pela API")
public record CategoriaResponseDTO (

        @Schema(
                description = "Identificador da categoria",
                example = "1"
        )

        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long id,

        @Schema(
                description = "Nome de uma categoria",
                example = "ação"
        )
        @NotNull(message = "O nome é obrigatório")
        String nome,

        @Schema(
                description = "Última atualização do cadastro da categoria",
                example = "10-12-2000"
        )
        Timestamp ultima_atualizacao
) {}