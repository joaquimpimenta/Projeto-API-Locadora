package br.com.mi81.api_locadora.dto.atorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Dados necessários para cadastrar um novo ator
 * @param primeiro_nome primeiro nome do ator
 * @param ultimo_nome último nome do ator
 */
@Schema(description = "Dados utilizados para cadastrar um produto")

public record AtorRequestDTO (
        @NotNull(message = "O primeiro nome é obrigatório")
        String primeiro_nome,

        @NotNull(message = "O último nome é obrigatório")
        String ultimo_nome
) {}
