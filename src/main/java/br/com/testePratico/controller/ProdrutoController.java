
package br.com.testePratico.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping()
	public ResponseEntity<Produto> salvar(@Valid @RequestBody ProdutoDTO produtoDTO) throws URISyntaxException{
		Produto produto = produtoService.salvar(produtoDTO);
		return ResponseEntity.created(new URI(API + produto.getId())).body(produto);
	}
	
	@GetMapping("/verificarValidade")
	public List<Produto> verificarValidade() { //VERIFICA SE TEM ALGUM RPODUTO PERTO DE VENCER
		List<Produto> produtos = produtoService.verificarValidade();
		return produtos;
	}
	
	@GetMapping("/ProdudosDisponiveis") //BUSCA TODOS OS PRODUTOS DISPONIVEIS NA GELADEIRA
	public ResponseEntity<List<Produto>> buscarProdudosDisponiveis() {
		List<Produto> produtos = produtoService.buscarProdudosDisponiveis();
		return ResponseEntity.ok().body(produtos);
	}
	
	
	@GetMapping("/buscarCompra/{id}") // BUSCA TODOS OS PRODUTOS ATIVOS DE UMA COMPRA
	public ResponseEntity<List<Produto>> buscarCompraid(@PathVariable ("id") Long id) {
		List<Produto> produtos = produtoService.buscarCompraid(id);
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping("/buscarProduto") // BUSCA UM PROTUDO POR NOME
	public ResponseEntity<List<Produto>> buscarProdutoNome(@RequestParam String nome) {
		List<Produto> produtos = produtoService.buscarProdutoNome(nome);
		return ResponseEntity.ok().body(produtos);
	}
	
	
	@GetMapping("/desabilitarProduto/{id}") //DESABILITA UM PRODUTO
	public ResponseEntity<List<Produto>> desabilitar(@PathVariable ("id") Long id){
		List<Produto> produtos = produtoService.desabilitar(id);
		return ResponseEntity.ok().body(produtos);
	}
	
	@PutMapping("/alterar/{id}") //ALTERA UM PRODUTO
	public ResponseEntity<Produto> alterar(@Valid @RequestBody ProdutoDTO produtoDTO, @PathVariable ("id") Long id)throws URISyntaxException{
		produtoDTO.setId(id);
		Produto produto = produtoService.salvar(produtoDTO);
		return ResponseEntity.created(new URI(API + produto.getId())).body(produto);
	}
}