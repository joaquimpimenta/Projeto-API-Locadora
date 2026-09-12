package br.com.mi81.api_locadora.repository;

import br.com.mi81.api_locadora.entity.Ator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio responsavel pelo acesso dos dados de atores
 */
public interface AtorRepository extends JpaRepository<Ator, Long> {
}
