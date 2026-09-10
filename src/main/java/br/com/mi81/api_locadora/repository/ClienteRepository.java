package br.com.mi81.api_locadora.repository;

import br.com.mi81.api_locadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}