package br.com.mi81.api_locadora.dto.atorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Timestamp;

/**
 * Representação pública de um ator retornado pela API
 * @param primeiro_nome primeiro nome do ator
 * @param ultimo_nome último nome do ator
 */
@Schema(description = "Dados de um ator retornado pela API")
public record AtorResponseDTO (
        @Schema(
                description = "Identificador do cliente",
                example = "1"
        )

        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long ator_id,

        @Schema(
                description = "Primeiro nome do ator",
                example = "Brad"
        )
        @NotNull(message = "O primeiro nome é obrigatório")
        String primeiro_nome,

        @Schema(
                description = "Último nome do ator",
                example = "Pitt"
        )
        String ultimo_nome,

        @Schema(
                description = "Última atualização do cadastro do usuário",
                example = "10-12-2000"
        )
        Timestamp ultima_atualizacao
) {}
