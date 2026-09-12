package br.com.mi81.api_locadora.controller;

import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaRequestDTO;
import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaResponseDTO;
import br.com.mi81.api_locadora.dto.categoriaDTO.CategoriaUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Categoria;
import br.com.mi81.api_locadora.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(
        name = "Categorias",
        description = "Operações relacionadas ao gerenciamento de Categorias"
)
@RestController
@RequestMapping("/api-locadora/v1/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    /**
     * Lista todos as Categorias cadastradas
     * @return Lista de Categorias
     */

    @Operation (
            summary = "Lista de Categorias",
            description = "Retorna todas as categorias cadastradas"
    )

    @ApiResponse (
            responseCode = "200",
            description = "Categorias retornadas com sucesso"
    )

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listar (){
        return ResponseEntity.ok(service.listar());
    }

    /**
     * Busca uma Categoria pelo seu Indentificador único
     * @param id Identificador da Categoria
     * @return DTO com os dados da Categoria encontrada
     */

    @Operation (
            summary = "Busca Categoria por ID",
            description = "Retorna a Categoria com o mesmo ID especificado"
    )

    @ApiResponse (
            responseCode = "200",
            description = "Categoria encontrada com sucesso"
    )

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId (
            @Parameter(description = "Identificador único do produto", example = "1")
            @PathVariable Long id
    ){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    /**
     * Cadastra uma nova Categoria
     * @param requestDTO DTO com os dados necessários para a criação de uma Categoria
     * @return DTO com a Categoria cadastrada e cabeçalho Location
     */

    @Operation (
            summary = "Cadastro de uma Categoria",
            description = "Cria uma nova Categoria no catálogo e retorna o recurso criado"
    )

    @ApiResponses({
            @ApiResponse (
                    responseCode = "201",
                    description = "Categoria criado com sucesso"
            ),
            @ApiResponse (
                    responseCode = "400",
                    description = "Dados de requisição inválidos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })

    @PostMapping("/cadastrar")
    public ResponseEntity<CategoriaResponseDTO> cadastrar (@Valid @RequestBody CategoriaRequestDTO requestDTO) {
        CategoriaResponseDTO categoria = service.cadastrar(requestDTO);
        System.out.println(categoria = service.cadastrar(requestDTO));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.id())
                .toUri();

        return ResponseEntity.created(uri).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> atualizar (
            @Parameter(description = "Identificador único do produto", example = "1")
            @PathVariable Long id, @Valid @RequestBody CategoriaUpdateRequestDTO requestDTO) {

        return ResponseEntity.ok(service.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover (
            @Parameter(description = "Identificador único do produto", example = "1")
            @PathVariable Long id) {

        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
