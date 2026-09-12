package br.com.mi81.api_locadora.mapper;

import br.com.mi81.api_locadora.dto.clienteDTO.ClienteRequestDTO;
import br.com.mi81.api_locadora.dto.clienteDTO.ClienteResponseDTO;
import br.com.mi81.api_locadora.dto.clienteDTO.ClienteUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    /**
     * Converte dados de criação para uma entidade cliente.
     * @param request dados recebidos para criação
     * @return entidade cliente
     */

    public Cliente toEntity(ClienteRequestDTO request){
        return Cliente.builder()
                .loja_id(request.loja_id())
                .primeiroNome(request.primeiroNome())
                .ultimoNome(request.ultimoNome())
                .email(request.email())
                .endereco_id(request.endereco_id())
                .dataCriacao(request.dataCriacao())
                .build();
    }

    /**
     * Converte uma entidade cliente para o DTO de resposta.
     * @param cliente entidade persistida
     * @return representação publica cliente.
     */

    public ClienteResponseDTO toResponse(Cliente cliente){
        return new ClienteResponseDTO(
                cliente.getCliente_id(),
                cliente.getLoja_id(),
                cliente.getPrimeiroNome(),
                cliente.getUltimoNome(),
                cliente.getEmail(),
                cliente.getEndereco_id(),
                cliente.getDataCriacao(),
                cliente.isAtivo(),
                cliente.getUltimaAtualizacao());
    }

    /**
     * Converte uma lista de Entidades para uma lista de DTOs de resposta
     */
    public List<ClienteResponseDTO> toResponseList(List<Cliente> clientes){
        return clientes.stream()
                .map(this::toResponse)
                .toList();
    }

    public void updateEntity(ClienteUpdateRequestDTO request, Cliente cliente){
        cliente.setPrimeiroNome(request.primeiroNome());
        cliente.setUltimoNome(request.ultimoNome());
        cliente.setEmail(request.email());
        cliente.setEndereco_id(request.endereco_id());
        cliente.setAtivo(request.ativo());
    }
}
