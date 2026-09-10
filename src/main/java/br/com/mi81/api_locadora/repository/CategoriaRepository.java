package br.com.mi81.api_locadora.repository;

import br.com.mi81.api_locadora.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
