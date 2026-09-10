package br.com.mi81.api_locadora.controller;

import br.com.mi81.api_locadora.dto.clienteDTO.ClienteRequestDTO;
import br.com.mi81.api_locadora.dto.clienteDTO.ClienteResponseDTO;
import br.com.mi81.api_locadora.dto.clienteDTO.ClienteUpdateRequestDTO;
import br.com.mi81.api_locadora.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/v1/locadora")
@RestController
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{cliente_id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long cliente_id){
        return ResponseEntity.ok(service.buscarPorId(cliente_id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteResponseDTO> cadastrar(@Valid @RequestBody ClienteRequestDTO requestDTO){
        ClienteResponseDTO cliente = service.inserir(requestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.id())
                .toUri();

        return ResponseEntity.created(uri).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteUpdateRequestDTO request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover (@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

}
