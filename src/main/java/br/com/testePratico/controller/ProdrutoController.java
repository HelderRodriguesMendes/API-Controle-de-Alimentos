package br.com.testePratico.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testePratico.model.Produto;
import br.com.testePratico.modelDTO.ProdutoDTO;
import br.com.testePratico.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdrutoController {

	@Autowired
	ProdutoService produtoService;
	
	private static final String API = "/produto";
	
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
	public ResponseEntity<List<Produto>> desabilitar(@PathVariable ("id") Long id){
		List<Produto> produtos = produtoService.desabilitar(id);
		return ResponseEntity.ok().body(produtos);
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Produto> alterar(@Valid @RequestBody ProdutoDTO produtoDTO, @PathVariable ("id") Long id)throws URISyntaxException{
		produtoDTO.setId(id);
		Produto produto = produtoService.salvar(produtoDTO);
		return ResponseEntity.created(new URI(API + produto.getId())).body(produto);
	}
}