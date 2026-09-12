package br.com.mi81.api_locadora.controller;

import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelRequestDTO;
import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelResponseDTO;
import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelUpdateRequestDTO;
import br.com.mi81.api_locadora.service.AluguelService;
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

/**
 * Controller REST responsavel pelos endpoints relacionados ao recurso aluguel
 */
@Tag(
        name = "Alugueis",
        description = "Operações relacionadas ao gerenciamento de aluguéis"
)
@RequestMapping("/api-locadora/v1/aluguel")
@RestController
public class AluguelController {

    private final AluguelService service;

    public AluguelController(AluguelService service) {
        this.service = service;
    }

    /**
     * Lista todos os aluguéis cadastrados
     * @return Lista de alugueis
     */
    @Operation(
            summary = "Lista de alugueis",
            description = "Retorna todos os alugueis cadastrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Alugueis retornados com sucesso"
    )
    @GetMapping("/listar")
    public ResponseEntity<List<AluguelResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @Operation(
            summary = "Busca aluguel por ID",
            description = "Retorna os detalhes de um aluguel especifico com base no seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Aluguel encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aluguel não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{aluguel_id}")
    public ResponseEntity<AluguelResponseDTO> buscarPorId(
            @Parameter(description = "identificador unico do aluguel", example = "1")
            @PathVariable Long aluguel_id){
        return ResponseEntity.ok(service.buscarPorId(aluguel_id));
    }

    @Operation(
            summary = "Cadastra um cliente",
            description = "Cria um novo cliente, e retorna o recurso criado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados de requisição invalidos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<AluguelResponseDTO> cadastrar(@Valid @RequestBody AluguelRequestDTO requestDTO){
        AluguelResponseDTO aluguel = service.cadastrar(requestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{aluguel_id}")
                .buildAndExpand(aluguel.aluguel_id())
                .toUri();

        return ResponseEntity.created(uri).body(aluguel);
    }

    /**
     * Atualizar os dados de um aluguel existente
     * @param id Identificador único do aluguel a ser atualizado
     * @param requestDTO DTO com os novos dados do aluguel
     * @return DTO atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<AluguelResponseDTO> atualizar(
            @Parameter(description = "identificador unico do cliente", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody AluguelUpdateRequestDTO requestDTO){
        return ResponseEntity.ok(service.atualizar(id, requestDTO));
    }

    /**
     * Remove um aluguel
     * @param id Identificador unico do aluguel a ser removido
     * @return Resposta sem conteudo (HTTP 204 no Content)
     */
    @Operation(
            summary = "Remove um aluguel",
            description = "Realiza uma exclusão do aluguel com base no seu identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Aluguel removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aluguel não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover (@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}