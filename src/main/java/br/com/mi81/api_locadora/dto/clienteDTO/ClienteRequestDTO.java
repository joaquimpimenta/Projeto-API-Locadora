package br.com.mi81.api_locadora.dto.clienteDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteRequestDTO(
        Long loja_id,
        String primeiroNome,
        String ultimoNome,
        String email,
        Long endereco_id,
        LocalDate dataCriacao,
        boolean ativo
) {}
