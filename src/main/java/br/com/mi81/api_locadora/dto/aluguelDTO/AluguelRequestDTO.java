package br.com.mi81.api_locadora.dto.aluguelDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

/**
 * Dados necessários para cadastrar um novo aluguel
 *
 * @param data_de_aluguel data do aluguel
 * @param inventario_id identificador do inventário do aluguel
 * @param cliente_id identificador do cliente do aluguel
 * @param data_de_devolucao data de devolução do aluguel
 * @param funcionario_id identificador do funcionário do aluguel
 */
@Schema(description = "Dados utilizados para cadastrar um aluguel")
public record AluguelRequestDTO (
        @Schema(
                description = "Data do aluguel",
                example = "14-09-2001"
        )
        @NotNull(message = "A data do aluguel é obrigatória")
        LocalDate data_de_aluguel,

        @Schema(
                description = "Identificador do inventário do aluguel",
                example = "1"
        )
        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long inventario_id,

        @Schema(
                description = "Identificador do cliente do aluguel",
                example = "1"
        )
        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long cliente_id,

        @Schema(
                description = "Data de devolução do aluguel",
                example = "15-09-2001"
        )
        @NotNull(message = "A data de devolução do aluguel é obrigatória")
        LocalDate data_de_devolucao,

        @Schema(
                description = "Identificador do funcionário do aluguel",
                example = "1"
        )
        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long funcionario_id
){}
