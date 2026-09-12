package br.com.mi81.api_locadora.dto.atorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Dados utilizados para atualizar totalmente o ator
 * @param primeiro_nome novo primeiro nome do ator
 * @param ultimo_nome novo último nome do ator
 */
@Schema(description = "Dados para atualização de um ator")
public record AtorUpdateRequestDTO(

        @Schema(
                description = "Novo primeiro nome do ator",
                example = "Marlon"
        )
        @NotNull(message = "O primeiro nome é obrigatório")
        String primeiro_nome,

        @Schema(
                description = "Novo último nome do ator",
                example = "Brando"
        )
        @NotNull(message = "O último nome é obrigatório")
        String ultimo_nome
) {}
