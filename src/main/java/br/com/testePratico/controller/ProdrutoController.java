/*package br.com.testePratico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	public List<Produto> salvar(@Valid @RequestBody List<Produto> produtos) {
		List<Produto> produtos = produtoService.salvar(produtos);
		return produtos;
	}
}*/
