package br.com.mi81.api_locadora.service;

import br.com.mi81.api_locadora.dto.clienteDTO.ClienteRequestDTO;
import br.com.mi81.api_locadora.dto.clienteDTO.ClienteResponseDTO;
import br.com.mi81.api_locadora.dto.clienteDTO.ClienteUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Cliente;
import br.com.mi81.api_locadora.mapper.ClienteMapper;
import br.com.mi81.api_locadora.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pela regra de negócio * relacionadas ao gerenciamento de clientes
 */
@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Cadastra um novo cliente
     * @param requestDTO Objeto contendo os dados de entrada para a criação de cliente
     * @return DTO com os dados do cliente persistida
     */
    public ClienteResponseDTO cadastrar(ClienteRequestDTO requestDTO){
        Cliente cliente = mapper.toEntity(requestDTO);
        cliente.setAtivo(true);
        Cliente salvo = repository.save(cliente);
        return mapper.toResponse(salvo);
    }

    /**
     * Retorna todos os clientes
     * @return lista de DTOs representando os clientes encontrados na lista
     */
    public List<ClienteResponseDTO> listar(){
        List<Cliente> clientes = repository.findAll();
        return mapper.toResponseList(clientes);
    }

    /**
     * Busca um cliente pelo seu ID
     * @param id Identificador do cliente a ser localizado
     * @return DTO representando um cliente a ser encontrado
     * @throws EntityNotFoundException Se não encontrar um cliente com ID informado
     */
    public ClienteResponseDTO buscarPorId(Long id){

        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(()
                        -> new EntityNotFoundException("Cliente não encontrado para o ID: " + id));
    }

    /**
     * Atualiza todos os dados de um cliente existente
     *
     * @param id Identificador do cliente a ser atualizado
     * @param request DTO com os novos dados do cliente
     * @return DTO com os dados do cliente atualizada
     * @throws EntityNotFoundException Se não encontrar um cliente com ID informado
     */
    public ClienteResponseDTO atualizar(Long id, ClienteUpdateRequestDTO request){
        Cliente cliente = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cliente não encontrado para o ID: " + id));

        mapper.updateEntity(request, cliente);

        Cliente clienteAtualizado = repository.save(cliente);

        return mapper.toResponse(clienteAtualizado);
    }

    /**
     * Remove um cliente da base de dados pelo ID
     * @param id Identificador do cliente a ser removido
     * @throws EntityNotFoundException Se não encontrar um cliente com ID informado
     */

    public void remover(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cliente não contrado com o ID: " + id));

        repository.delete(cliente);
    }

}