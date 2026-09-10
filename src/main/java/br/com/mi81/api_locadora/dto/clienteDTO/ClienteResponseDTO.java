package br.com.mi81.api_locadora.dto.clienteDTO;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteResponseDTO (
        Long id,
        Long loja_id,
        String primeiroNome,
        String ultimoNome,
        String email,
        Long endereco_id,
        boolean ativo,
        LocalDate dataCriacao,
        Timestamp ultimaAtualizacao
) {}