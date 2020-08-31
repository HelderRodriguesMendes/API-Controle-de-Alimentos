package br.com.testePratico.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.testePratico.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	@Transactional
	@Query(value = "SELECT * from compra where inativo = 0 and supermercado = ?1", nativeQuery = true)
	List<Compra> findBySupermercado(String nome);
	
	@Transactional
	@Query(value = "SELECT * from compra where inativo = 0 and datacompra = ?1", nativeQuery = true)
	List<Compra> findByDatacompra(LocalDate datacompra);
	
	@Transactional
	@Query(value = "SELECT * from compra where inativo = 0", nativeQuery = true)
	List<Compra> comprasAtivas();
	
	@Transactional
	@Modifying
	@Query(value =  "update compra set inativo = '1' where id =?1", nativeQuery = true)
	void desabilitarProduto(Long id);
	
}
