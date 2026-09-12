package br.com.mi81.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

/**
 * Representa um cidade persistindo pela aplicação
 * <p>Esta entidade contém os dados internos utilizados pela camada de persistência</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidade")
@Builder
@Data
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidade_id;

    @Column(nullable = false)
    private String cidade;

    private Long pais_id;

    private Timestamp ultima_atualizacao;
}
