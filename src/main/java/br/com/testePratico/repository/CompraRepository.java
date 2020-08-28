package br.com.testePratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testePratico.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
