package br.com.mi81.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa um cliente persistindo pela aplicação
 * <p>Esta entidade contém os dados internos utilizados pela camada de persistência</p>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@Builder
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private Long loja_id;

    @Column(name = "primeiro_nome", nullable = false)
    private String primeiroNome;

    @Column(name = "ultimo_nome", nullable = false)
    private String ultimoNome;

    @Column(name = "email", nullable = false)
    private String email;

    private Long endereco_id;

    @Column(nullable = false)
    private boolean ativo;

    @CreatedDate
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @UpdateTimestamp
    @Column(name = "ultima_atualizacao")
    private Timestamp ultimaAtualizacao;

}
