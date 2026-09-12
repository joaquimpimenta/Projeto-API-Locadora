package br.com.mi81.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

/**
 * Representa um ator persistindo pela aplicação
 * <p>Esta entidade contém os dados internos utilizados pela camada de persistência</p>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ator")
@Builder
@Data
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ator_id;

    @Column(nullable = false)
    private String primeiro_nome;

    @Column(nullable = false)
    private String ultimo_nome;

    @UpdateTimestamp
    @Column(name = "ultima_atualizacao")
    private Timestamp ultima_atualizacao;
}
