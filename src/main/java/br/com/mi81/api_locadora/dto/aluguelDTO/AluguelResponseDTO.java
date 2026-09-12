package br.com.mi81.api_locadora.dto.aluguelDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

/**
 * Representação pública de um aluguel retornado pela API
 * @param aluguel_id identificador do aluguel
 * @param data_de_aluguel data do aluguel
 * @param inventario_id identificador do inventario do aluguel
 * @param cliente_id identificador do cliente que realizou o aluguel
 * @param data_de_devolucao data de devolução do aluguel
 * @param funcionario_id identificador do funcionário que realizou o aluguel
 */
@Schema(description = "Dados do aluguel retornado pela API")
public record AluguelResponseDTO (
        @Schema(
                description = "Identificador do aluguel",
                example = "1"
        )
        @NotNull(message = "O Id não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long aluguel_id,

        @Schema(
                description = "Data do aluguel",
                example = "14-09-2001"
        )
        @NotNull(message = "A data é obrigatória")
        LocalDate data_de_aluguel,

        @Schema(
                description = "Identificador do aluguel",
                example = "1"
        )
        @NotNull(message = "O Id não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long inventario_id,

        @Schema(
                description = "Identificador do aluguel",
                example = "1"
        )
        @NotNull(message = "O Id não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long cliente_id,

        @Schema(
                description = "Data de criação do aluguel",
                example = "10-12-2000"
        )
        @NotNull(message = "A data é obrigatória")
        LocalDate data_de_devolucao,

        @Schema(
                description = "Identificador do aluguel",
                example = "1"
        )
        @NotNull(message = "O Id não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long funcionario_id
){}
