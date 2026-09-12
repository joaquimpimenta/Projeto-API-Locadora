package br.com.mi81.api_locadora.dto.clienteDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Timestamp;

/**
 * Dados utilizados para atualizar completamente o cliente
 * @param primeiroNome novo primeiro nome do cliente
 * @param ultimoNome novo último nome do cliente
 * @param email novo email do cliente
 * @param endereco_id novo endereco_id do cliente
 * @param ativo nova situação do cliente
 * @param ultimaAtualizacao data da última atulização realizada
 */
@Schema(description = "Dados para atualização de um cliente")
public record ClienteUpdateRequestDTO(

        @Schema(
                description = "Novo primeiro nome do cliente",
                example = "João"
        )
        @NotNull(message = "O primeiro nome é obrigatório")
        String primeiroNome,

        @Schema(
                description = "Novo último nome do cliente",
                example = "Paulo"
        )
        @NotNull(message = "O último nome é obrigatório")
        String ultimoNome,

        @Schema(
                description = "Novo email do cliente",
                example = "cleiton@ronaldo.com"
        )
        @NotNull(message = "O email é obrigatório")
        String email,

        @Schema(
                description = "Novo identificador do endereço da loja",
                example = "1"
        )
        @NotNull(message = "ID não pode ser nulo")
        @Positive(message = "O ID deve ser um número positivo")
        Long endereco_id,

        @Schema(
                description = "Verificação de atividade da conta do cliente atualizada",
                example = "true"
        )
        boolean ativo,

        @Schema(
                description = "Última atualização do cadastro do usuário realizada",
                example = "10-12-2000"
        )
        Timestamp ultimaAtualizacao
) {}
