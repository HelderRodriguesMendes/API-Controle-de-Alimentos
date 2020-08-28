/*package br.com.testePratico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.testePratico.model.Supermercado;

@Repository
public interface SupermecadoRepository extends  JpaRepository<Supermercado, Long>{
	
	@Query(value = "select * from supermercado where inativo = '0' order by nome", nativeQuery = true)
	List<Supermercado> findByInativo();
	
	@Modifying
	@Query(value =  "update supermercado set inativo = '1' where id =?1", nativeQuery = true)
	void desabilitarSupermercado(Long id);
	
	@Query(value = "select * from supermercado where inativo = '0' and nome like %?1%", nativeQuery = true)
	List<Supermercado> findByNome(String nome);
	
}*/
