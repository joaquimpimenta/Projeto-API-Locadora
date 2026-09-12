package br.com.mi81.api_locadora.service;

import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaRequestDTO;
import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaResponseDTO;
import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Categoria;
import br.com.mi81.api_locadora.mapper.CategoriaMapper;
import br.com.mi81.api_locadora.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsavel pela regra de negocio * relacionadas ao gerenciamento de categorias
 */
@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaService(CategoriaRepository repository, CategoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Cadastra uma nova categoria
     * @param requestDTO Objeto contendo os dados de entrada para a criação da Categoria
     * @return DTO com os dados da Categoria persistida
     */
    public CategoriaResponseDTO cadastrar(CategoriaRequestDTO requestDTO){
        Categoria categoria = mapper.toEntity(requestDTO);

        Categoria salvo = repository.save(categoria);

        return mapper.toResponse(salvo);
    }

    /**
     * Retorna todas as Categorias
     * @return lista de DTOs representando as Categorias encontradas na lista
     */
    public List<CategoriaResponseDTO> listar(){
        List<Categoria> categorias = repository.findAll();
        return mapper.toResponseList(categorias);
    }

    /**
     * Busca uma Categoria pelo seu ID
     * @param id Identificador da Categoria a ser localizado
     * @return DTO representando a Categoria encontrada
     * @throws EntityNotFoundException Se não encontrar uma Categoria com ID informado
     */
    public CategoriaResponseDTO buscarPorId(Long id){
        return repository.findById(id).
                map(mapper::toResponse).orElseThrow(()
                        -> new EntityNotFoundException("Categoria não encontrada para id: " + id));
    }

    /**
     * Atualiza todos os dados de uma Categoria existente
     *
     * @param id Identificador da Categoria a ser atualizado
     * @param requestDTO DTO com os novos dados da Categoria
     * @return DTO com os dados da Categoria atualizada
     * @throws EntityNotFoundException Se não encontrar uma Categoria com ID informado
     */
    public CategoriaResponseDTO atualizar(Long id, CategoriaUpdateRequestDTO requestDTO){
        Categoria categoria = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Categoria não encontrada para id: " + id));

        mapper.updateEntity(requestDTO, categoria);

        Categoria atualizado = repository.save(categoria);

        return mapper.toResponse(atualizado);
    }

    /**
     * Remove uma Categoria da base de dados pelo ID
     * @param id Identificador da Categoria a ser removido
     * @throws EntityNotFoundException Se não encontrar uma Categoria com ID informado
     */

    public void remover(Long id){
        Categoria categoria = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Categoria não encontrada para id: " + id));

        repository.delete(categoria);
    }
}