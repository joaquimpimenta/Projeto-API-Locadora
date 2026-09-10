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

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteResponseDTO inserir(ClienteRequestDTO requestDTO){
        Cliente cliente = mapper.toEntity(requestDTO);
        cliente.setAtivo(true);
        Cliente salvo = repository.save(cliente);
        return mapper.toResponse(salvo);
    }

    public List<ClienteResponseDTO> listar(){
        List<Cliente> clientes = repository.findAll();
        return mapper.toResponseList(clientes);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteUpdateRequestDTO request){
        Cliente cliente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para o ID: " + id));

        mapper.updateEntity(request, cliente);

        Cliente clienteAtualizado = repository.save(cliente);

        return mapper.toResponse(clienteAtualizado);
    }

    public ClienteResponseDTO buscarPorId(Long id){

        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para o ID: " + id));
    }

    public void remover(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cliente não contrado com o ID: " + id));

        repository.delete(cliente);
    }

}