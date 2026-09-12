package br.com.mi81.api_locadora.service;

import br.com.mi81.api_locadora.dto.atorDTO.AtorRequestDTO;
import br.com.mi81.api_locadora.dto.atorDTO.AtorResponseDTO;
import br.com.mi81.api_locadora.dto.atorDTO.AtorUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Ator;
import br.com.mi81.api_locadora.mapper.AtorMapper;
import br.com.mi81.api_locadora.repository.AtorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsavel pela regra de negocio * relacionadas ao gerenciamento de atores
 */
@Service
public class AtorService {

    private final AtorRepository repository;
    private final AtorMapper mapper;

    public AtorService(AtorRepository repository, AtorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Cadastra um novo ator
     * @param requestDTO Objeto contendo os dados de entrada para a criação de ator
     * @return DTO com os dados do ator persistida
     */
    public AtorResponseDTO cadastrar(AtorRequestDTO requestDTO){
        Ator ator = mapper.toEntity(requestDTO);

        Ator salvo = repository.save(ator);

        return mapper.toResponse(salvo);
    }

    /**
     * Retorna todos os atores
     * @return lista de DTOs representando os atores encontrados na lista
     */
    public List<AtorResponseDTO> listar(){
        List<Ator> atores = repository.findAll();
        return mapper.toResponseList(atores);
    }

    /**
     * Busca um ator pelo seu ID
     * @param id Identificador do ator a ser localizado
     * @return DTO representando um ator a ser encontrado
     * @throws EntityNotFoundException Se não encontrar um ator com ID informado
     */
    public AtorResponseDTO buscarPorId(Long id){
        return repository.findById(id).
                map(mapper::toResponse).
                orElseThrow(()
                        -> new EntityNotFoundException("Ator não encontrado para o id: " + id));
    }

    /**
     * Atualiza todos os dados de um ator existente
     *
     * @param id Identificador do ator a ser atualizado
     * @param requestDTO DTO com os novos dados do ator
     * @return DTO com os dados do ator atualizada
     * @throws EntityNotFoundException Se não encontrar um ator com ID informado
     */
    public AtorResponseDTO atualizar(Long id, AtorUpdateRequestDTO requestDTO){
        Ator ator = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Ator não encontrado para o id: " + id));

        mapper.updateEntity(requestDTO, ator);

        Ator atualizado = repository.save(ator);

        return mapper.toResponse(atualizado);
    }

    /**
     * Remove um ator da base de dados pelo ID
     * @param id Identificador do ator a ser removido
     * @throws EntityNotFoundException Se não encontrar um ator com ID informado
     */
    public void remover(Long id){
        Ator ator = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Ator não encontrado para o id: " + id));
        repository.delete(ator);
    }
}
