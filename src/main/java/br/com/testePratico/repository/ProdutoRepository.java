package br.com.testePratico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testePratico.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
