package br.com.testePratico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}