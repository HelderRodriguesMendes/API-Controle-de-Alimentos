package br.com.testePratico.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Compra> salvar(@Valid @RequestBody CompraDTO compraDTO) throws URISyntaxException {
		Compra compra = compraService.salvar(compraDTO);
		return ResponseEntity.created(new URI(API + compra.getId())).body(compra);
	}

	@GetMapping("/pesquisarSupermercado")
	public ResponseEntity<List<Compra>> buscarSupermercado(@RequestParam String nome) {
		List<Compra> compras = compraService.buscarSupermercado(nome);
		return ResponseEntity.ok(compras);
	}
	
	@GetMapping("/pesquisarDatacompra")
	public ResponseEntity<List<Compra>> buscarDatacompra(@RequestParam String dataC) {
		LocalDate dataCompra = LocalDate.parse(dataC);
		List<Compra> compras = compraService.buscarDatacompra(dataCompra);
		return ResponseEntity.ok().body(compras);
	}
	
	//FALTA ALTERAR E DESABILITAR
}
