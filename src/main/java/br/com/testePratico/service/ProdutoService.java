package br.com.testePratico.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testePratico.model.Produto;
import br.com.testePratico.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	public void salvar(Produto produto) {
		produto = produtoRepository.save(produto);
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
	
	//FLATA ALTERA PRODUTOS
}
