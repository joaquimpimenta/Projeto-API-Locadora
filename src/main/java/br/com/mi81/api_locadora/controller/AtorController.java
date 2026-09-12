package br.com.mi81.api_locadora.controller;

import br.com.mi81.api_locadora.dto.atorDTO.AtorRequestDTO;
import br.com.mi81.api_locadora.dto.atorDTO.AtorResponseDTO;
import br.com.mi81.api_locadora.dto.atorDTO.AtorUpdateRequestDTO;
import br.com.mi81.api_locadora.service.AtorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.Servlet;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(
        name = "Ator",
        description = "Operações relacionadas ao gerenciamento de Atores"
)
@RestController
@RequestMapping("/api-locadora/v1/ator")
public class AtorController {

    private final AtorService service;

    public AtorController(AtorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AtorResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtorResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AtorResponseDTO> cadastrar(@Valid @RequestBody AtorRequestDTO requestDTO){
        AtorResponseDTO ator = service.cadastrar(requestDTO);

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(ator.ator_id()).
                toUri();

        return ResponseEntity.created(uri).body(ator);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtorResponseDTO> atualizar
            (@PathVariable Long id, @Valid @RequestBody AtorUpdateRequestDTO requestDTO){
        return ResponseEntity.ok(service.atualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
