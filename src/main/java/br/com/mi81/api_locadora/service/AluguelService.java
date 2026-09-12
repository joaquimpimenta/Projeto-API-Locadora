package br.com.mi81.api_locadora.service;

import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelRequestDTO;
import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelResponseDTO;
import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Aluguel;
import br.com.mi81.api_locadora.mapper.AluguelMapper;
import br.com.mi81.api_locadora.mapper.ClienteMapper;
import br.com.mi81.api_locadora.repository.AluguelRepository;
import br.com.mi81.api_locadora.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pela regra de negócio * relacionadas ao gerenciamento de clientes
 */
@Service
public class AluguelService {

    private final AluguelRepository repository;
    private final AluguelMapper mapper;

    public AluguelService(AluguelRepository repository, AluguelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Cadastra um novo aluguel
     * @param requestDTO objeto contendo os dados de entrada para a criação de cliente
     * @return DTO com os dados do cliente persistida
     */
    public AluguelResponseDTO cadastrar(AluguelRequestDTO requestDTO){
        Aluguel aluguel = mapper.toEntity(requestDTO);
        Aluguel salvo = repository.save(aluguel);
        return mapper.toResponse(salvo);
    }

    /**
     * Retorna todos os aluguéis
     * @return lista de DTOs representado os clientes encontrados na lista
     */
    public List<AluguelResponseDTO> listar(){
        List<Aluguel> alugueis = repository.findAll();
        return mapper.toResponseList(alugueis);
    }

    /**
     * Busca um aluguel pelo seu ID
     * @param id Identificador do aluguel a ser localizado
     * @return DTO representando um aluguel a ser encontrado
     * @throws EntityNotFoundException Se não encontrar um aluguel com ID informado
     */
    public AluguelResponseDTO buscarPorId(Long id){

        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(()
                        -> new EntityNotFoundException("Aluguel não encontrado para o ID: " + id));
    }

    /**
     * Atualiza todos os dados de um aluguel existente
     *
     * @param id Identificador do aluguel a ser atualizado
     * @param requestDTO DTO com os novos dados do cliente
     * @return DTO com os dados do aluguel atualizado
     * @throws EntityNotFoundException Se não encontrar um aluguel com ID informado
     */
    public AluguelResponseDTO atualizar(Long id, AluguelUpdateRequestDTO requestDTO){
        Aluguel aluguel = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Aluguel não encontrado para o ID:" + id));

        mapper.updateEntity(requestDTO, aluguel);

        Aluguel aluguelAtualizado = repository.save(aluguel);

        return mapper.toResponse(aluguelAtualizado);
    }

    /**
     * Remove um aluguel da base de dados pelo ID
     * @param id Identificador do aluguel a ser removido
     * @throws EntityNotFoundException Se não encontrar um aluguel com ID informado
     */
    public void remover(Long id){
        Aluguel aluguel = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Aluguel não encontrado para o ID:" + id));

        repository.delete(aluguel);
    }
}
