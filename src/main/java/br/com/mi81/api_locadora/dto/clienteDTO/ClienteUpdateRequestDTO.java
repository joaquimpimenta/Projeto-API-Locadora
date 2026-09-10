package br.com.mi81.api_locadora.dto.clienteDTO;

public record ClienteUpdateRequestDTO(
        String primeiroNome,
        String ultimoNome,
        String email,
        Long endereco_id,
        boolean ativo
) {}
