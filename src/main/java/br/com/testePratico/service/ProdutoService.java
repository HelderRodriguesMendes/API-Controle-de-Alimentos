package br.com.testePratico.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testePratico.convercoesDTO.ProdutoMapper;
import br.com.testePratico.model.Compra;
import br.com.testePratico.model.Produto;
import br.com.testePratico.modelDTO.ProdutoDTO;
import br.com.testePratico.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	ProdutoMapper produtoMapper = new ProdutoMapper();

	public void salvar(@Valid ProdutoDTO produtoDTO, Compra compra) {
		System.out.println("COMPRA " + compra.getId());
		Produto p = produtoMapper.toEntity(produtoDTO);
		p.setCompra(compra);
		p = produtoRepository.save(p);
		
	}
	
}
