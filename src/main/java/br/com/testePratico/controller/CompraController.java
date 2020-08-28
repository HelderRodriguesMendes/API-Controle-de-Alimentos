package br.com.testePratico.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testePratico.model.Compra;
import br.com.testePratico.modelDTO.CompraDTO;
import br.com.testePratico.service.CompraService;

@RestController
@RequestMapping("alimentos/compra")
public class CompraController {

	@Autowired
	CompraService compraService;

	private static final String API = "/compra";
	
	@PostMapping()
	public ResponseEntity<Compra> salvar(@Valid @RequestBody CompraDTO compraDTO) throws URISyntaxException{		
		Compra compra = compraService.salvar(compraDTO);
		return ResponseEntity.created(new URI(API + compra.getId())).body(compra);
	}

}
