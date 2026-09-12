package br.com.mi81.api_locadora.dto.clienteDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Dados necessários para cadastrar um novo cliente
 *
 * @param loja_id identificador da loja
 * @param primeiroNome primeiro nome do cliente
 * @param ultimoNome ultimo nome do cliente
 * @param email email do cliente
 * @param endereco_id identificador do endereco do cliente
 * @param dataCriacao data de criação do cliente
 * @param ativo verificação se está ativo ou não
 */
@Schema(description = "Dados utilizados para cadastrar um produto")
public record ClienteRequestDTO(
        @Schema(
                description = "Identificador da loja",
                example = "1"
        )

        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long loja_id,

        @Schema(
                description = "Primeiro nome do cliente",
                example = "Cleiton"
        )
        @NotNull(message = "O primeiro nome é obrigatório")
        String primeiroNome,

        @Schema(
                description = "Último nome do client",
                example = "Ronaldo"
        )
        @NotNull(message = "O último nome é obrigatório")
        String ultimoNome,

        @Schema(
                description = "Email do cliente",
                example = "cleiton@ronaldo.com"
        )
        @NotNull(message = "O email é obrigatório")
        String email,

        @Schema(
                description = "Identificador do endereço da loja",
                example = "1"
        )
        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long endereco_id,

        @Schema(
                description = "Data de criação do usuário do cliente",
                example = "10-12-2000"
        )
        @NotNull(message = "A data é obrigatória")
        LocalDate dataCriacao,

        @Schema(
                description = "Verificação de atividade da conta do cliente",
                example = "true"
        )
        boolean ativo
) {}
