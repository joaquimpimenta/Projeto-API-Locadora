package br.com.mi81.api_locadora.dto.aluguelDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

/**
 * Dados para utilizados para atualizar completamente a categoria
 * @param data_de_aluguel nova data de aluguel
 * @param inventario_id novo identificador do inventario do aluguel
 * @param cliente_id novo identificador do cliente do aluguel
 * @param data_de_devolucao nova data de devolução do aluguel
 * @param funcionario_id novo identificador do funcionário do aluguel
 */
@Schema(description = "Dados para atualização de uma categoria")
public record AluguelUpdateRequestDTO(
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
) {}
