package br.com.testePratico.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testePratico.Exception.RegistroNaoEncontradoException;
import br.com.testePratico.convercoesDTO.ProdutoMapper;
import br.com.testePratico.model.Produto;
import br.com.testePratico.modelDTO.ProdutoDTO;
import br.com.testePratico.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	ProdutoMapper produtoMapper = new ProdutoMapper();

	public Produto salvar(ProdutoDTO produtoDTO) { //ALTERA UM PRODUTO
		Produto produto = produtoMapper.toEntity(produtoDTO);
		return produto = produtoRepository.save(produto);
	}
	
	public List<Produto> verificarValidade(){ //VERIFICA SE TEM ALGUM RPODUTO PERTO DE VENCER
		LocalDate DATA_ATUAL = LocalDate.now();
		LocalDate dataFutura =  DATA_ATUAL.plusWeeks(2);
		
		return produtoRepository.buscarDataValidade(DATA_ATUAL, dataFutura);
	}
	
	public List<Produto> buscarProdudosDisponiveis(){ //BUSCA TODOS OS PRODUTOS DISPONIVEIS NA GELADEIRA
		return produtoRepository.findByStatusconsumo();
	}
	
	public List<Produto> buscarCompraid(Long id){ // BUSCA TODOS OS PRODUTOS ATIVOS DE UMA COMPRA
		List<Produto> produtos = produtoRepository.findByCompraid(id);
		if (produtos.isEmpty()) {
			throw new RegistroNaoEncontradoException("Compra não encontrada");
		}
		return produtos;
	}
	
	public List<Produto> buscarProdutoNome(String nome){ // BUSCA TODOS OS PRODUTOS ATIVOS DE UMA COMPRA
		List<Produto> produtos = produtoRepository.findByNome(nome);
		if (produtos.isEmpty()) {
			produtos = new ArrayList<>();
		}
		return produtos;
	}
	
	public List<Produto> desabilitar(Long id){ //DESABILITA UM PRODUTO
		produtoRepository.desabilitarProduto(id);
		
		return buscarProdudosDisponiveis();
	}
}
