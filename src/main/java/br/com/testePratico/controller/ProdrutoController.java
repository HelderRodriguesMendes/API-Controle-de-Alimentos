package br.com.testePratico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testePratico.model.Produto;
import br.com.testePratico.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdrutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/verificarValidade")
	public List<Produto> verificarValidade() {
		List<Produto> produtos = produtoService.verificarValidade();
		return produtos;
	}
	
	@GetMapping("/ProdudosDisponiveis")
	public ResponseEntity<List<Produto>> buscarProdudosDisponiveis() {
		List<Produto> produtos = produtoService.buscarProdudosDisponiveis();
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping("/desabilitarProduto/{id}")
	public List<Produto> desabilitar(@PathVariable ("id") Long id){
		List<Produto> produtos = produtoService.desabilitar(id);
		return (produtos);
	}
}