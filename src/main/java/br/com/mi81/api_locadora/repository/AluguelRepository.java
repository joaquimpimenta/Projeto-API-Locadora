package br.com.mi81.api_locadora.repository;

import br.com.mi81.api_locadora.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio responsavel pelo acesso dos dados de categorias
 */
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
