package br.com.testePratico.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
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

import br.com.testePratico.model.Compra;
import br.com.testePratico.modelDTO.CompraDTO;
import br.com.testePratico.service.CompraService;

@RestController
@RequestMapping("alimentos/compra")
public class CompraController {

	@Autowired
	CompraService compraService;

	private static final String API = "alimentos/compra";

	@PostMapping() //SALVA A COMPRA E OS PRODUTOS
	public ResponseEntity<Compra> salvar(@Valid @RequestBody CompraDTO compraDTO) throws URISyntaxException {
		Compra compra = compraService.salvar(compraDTO, "salvar");
		return ResponseEntity.created(new URI(API + compra.getId())).body(compra);
	}

	
	@GetMapping("/listaCompras") //BUSCA TODAS AS COMPRAS DISPONIVEIS
	public ResponseEntity<List<Compra>> buscarTodas() {
		List<Compra> compras = compraService.buscarTodas();
		return ResponseEntity.ok(compras);
	}
	
	
	@GetMapping("/pesquisarSupermercado") //BUSCA POR SUPERMERCADO DE TODAS AS COMPRAS DISPONIVEIS
	public ResponseEntity<List<Compra>> buscarSupermercado(@RequestParam String nome) {
		List<Compra> compras = compraService.buscarSupermercado(nome);
		return ResponseEntity.ok(compras);
	}
	
	
	@GetMapping("/pesquisarDatacompra") //BUSCA POR DATA DA COMPRA DE TODAS AS COMPRAS DISPONIVEIS
	public ResponseEntity<List<Compra>> buscarDatacompra(@RequestParam String dataC) {
		LocalDate dataCompra = LocalDate.parse(dataC);
		List<Compra> compras = compraService.buscarDatacompra(dataCompra);
		return ResponseEntity.ok().body(compras);
	}
	
	
	@PutMapping("/alterar/{id}") //ALTERA UMA COMPRA
	public ResponseEntity<Compra> alterar(@Valid @RequestBody CompraDTO compraDTO, @PathVariable ("id") Long id)throws URISyntaxException{
		compraDTO.setId(id);
		Compra compra = compraService.salvar(compraDTO, "alterar");
		return ResponseEntity.created(new URI(API + compra.getId())).body(compra);
	}
	
	
	@GetMapping("/desabilitarCompra/{id}") //DESABILITA COMPRA
	public ResponseEntity<List<Compra>> desabilitar(@PathVariable ("id") Long id){
		List<Compra> produtos = compraService.desabilitar(id);
		return ResponseEntity.ok().body(produtos);
	}
}
