package br.com.testePratico.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testePratico.convercoesDTO.ProdutoMapper;
import br.com.testePratico.model.Produto;
import br.com.testePratico.modelDTO.ProdutoDTO;
import br.com.testePratico.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	ProdutoMapper produtoMapper = new ProdutoMapper();

	public Produto salvar(ProdutoDTO produtoDTO) {
		Produto produto = produtoMapper.toEntity(produtoDTO);
		return produto = produtoRepository.save(produto);
	}
	
	public List<Produto> verificarValidade(){
		LocalDate DATA_ATUAL = LocalDate.now();
		LocalDate dataFutura =  DATA_ATUAL.plusWeeks(2);
		
		return produtoRepository.buscarDataValidade(DATA_ATUAL, dataFutura);
	}
	
	public List<Produto> buscarProdudosDisponiveis(){
		return produtoRepository.findByStatusconsumo();
	}
	
	public List<Produto> desabilitar(Long id){
		produtoRepository.desabilitarProduto(id);
		
		return buscarProdudosDisponiveis();
	}
}
