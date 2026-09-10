package br.com.mi81.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private LocalDate dataCriacao;

    private Timestamp ultimaAtualizacao;

}
