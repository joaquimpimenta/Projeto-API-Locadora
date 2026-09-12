package br.com.mi81.api_locadora.mapper;

import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelRequestDTO;
import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelResponseDTO;
import br.com.mi81.api_locadora.dto.aluguelDTO.AluguelUpdateRequestDTO;
import br.com.mi81.api_locadora.entity.Aluguel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AluguelMapper {

    /**
     * Converte dados de criação para uma entidade aluguel
     * @param requestDTO dados recebidos para criação
     * @return entidade aluguel
     */
    public Aluguel toEntity(AluguelRequestDTO requestDTO){
        return Aluguel.builder()
                .data_de_aluguel(requestDTO.data_de_aluguel())
                .inventario_id(requestDTO.inventario_id())
                .cliente_id(requestDTO.cliente_id())
                .data_de_devolucao(requestDTO.data_de_devolucao())
                .funcionario_id(requestDTO.funcionario_id())
                .build();
    }

    /**
     * Converte uma entidade aluguel para o DTO de resposta
     * @param aluguel entidade persistida
     * @return representação pública aluguel
     */
    public AluguelResponseDTO toResponse(Aluguel aluguel){
        return new AluguelResponseDTO(
                aluguel.getAluguel_id(),
                aluguel.getData_de_aluguel(),
                aluguel.getInventario_id(),
                aluguel.getCliente_id(),
                aluguel.getData_de_devolucao(),
                aluguel.getFuncionario_id());
    }

    /**
     *Converte uma lista de Entidades para uma lista de DTOs de resposta
     */
    public List<AluguelResponseDTO> toResponseList(List<Aluguel> alugueis){
        return alugueis.stream().
                map(this::toResponse)
                .toList();
    }

    public void updateEntity(AluguelUpdateRequestDTO requestDTO, Aluguel aluguel){
        aluguel.setData_de_aluguel(requestDTO.data_de_aluguel());
        aluguel.setInventario_id(requestDTO.inventario_id());
        aluguel.setCliente_id(requestDTO.cliente_id());
        aluguel.setData_de_devolucao(requestDTO.data_de_devolucao());
        aluguel.setFuncionario_id(requestDTO.funcionario_id());
    }
}
