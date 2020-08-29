package br.com.testePratico.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.testePratico.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	@Transactional
	@Query(value = "SELECT DISTINCT  * from compra, produto where supermercado = ?1 and produto.compraid = compra.id", nativeQuery = true)
	List<Compra> findBySupermercado(String nome);
	
	@Transactional
	@Query(value = "SELECT DISTINCT  * from compra, produto where datacompra = ?1 and produto.compraid = compra.id", nativeQuery = true)
	List<Compra> findByDatacompra(LocalDate datacompra);
	
	
	
}
