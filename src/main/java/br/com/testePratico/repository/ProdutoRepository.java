package br.com.testePratico.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.testePratico.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	@Modifying
	@Transactional
	@Query(value = "select * from produto where datavalidade between ?1 and ?2", nativeQuery = true)
	List<Produto>  buscarDataValidade(LocalDate dataAtual, LocalDate dataFutura);
}


