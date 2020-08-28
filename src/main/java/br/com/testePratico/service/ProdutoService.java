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
	
	
	
	public Produto salvar(@Valid ProdutoDTO produtoDTO) {
		Produto produto = produtoMapper.toEntity(produtoDTO);
		return produto = produtoRepository.save(produto);
	}
	public void salvarLista( Compra compra) {
		 produtoRepository.saveAll(compra.getProdutos());
	}
}
