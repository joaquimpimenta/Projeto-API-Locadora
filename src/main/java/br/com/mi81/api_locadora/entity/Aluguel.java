package br.com.mi81.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Representa um aluguel persistindo pela aplicação
 * <p>Esta entidade contém os dados internos utilizados pela camda de persistência</p>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluguel")
@Builder
@Data
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aluguel_id;

    @CreatedDate
    @Column(name = "data_de_aluguel")
    private LocalDate data_de_aluguel;

    private Long inventario_id;

    private Long cliente_id;

    @CreatedDate
    @Column(name = "data_de_devolucao")
    private LocalDate data_de_devolucao;

    private Long funcionario_id;

    @UpdateTimestamp
    @Column(name = "ultima_atualizacao")
    private Timestamp ultima_atualizacao;
}
