/*package br.com.testePratico.controller;

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

import br.com.testePratico.model.Supermercado;
import br.com.testePratico.modelDTO.SupermercadoDTO;
import br.com.testePratico.service.SupermercadoServise;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {
	
	private static final String API = "/supermercado";
	
	@Autowired
	SupermercadoServise supermercadoServise;
	
	@PostMapping
	public ResponseEntity<Supermercado> salvar(@Valid @RequestBody SupermercadoDTO supermercadoDTO) throws URISyntaxException{
		Supermercado supermercado = supermercadoServise.salvar(supermercadoDTO);
		return ResponseEntity.created(new URI(API + supermercado.getId())).body(supermercado);
	}
	
	@GetMapping
	public List<Supermercado> listar(){
		List<Supermercado> supermercados = supermercadoServise.listar();
		return (supermercados);
	}
	
	@GetMapping("/pesquisarNome")
	public ResponseEntity<List<Supermercado>> consultarNome(@RequestParam String nome){
		List<Supermercado> supermercado = supermercadoServise.listarNome(nome);
	
		return ResponseEntity.ok().body(supermercado);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<List<Supermercado>> alterar(@Valid @PathVariable Long id, @RequestBody SupermercadoDTO supermercadoDTO){
		supermercadoServise.salvar(supermercadoDTO);
		List<Supermercado> supermercados = listar();
		return ResponseEntity.ok(supermercados);
	}

	@GetMapping("removerSupermercado/{id}")
	public List<Supermercado> desabilitar(@PathVariable ("id") Long id){
		List<Supermercado> supermercados = supermercadoServise.desabilitar(id);
		return (supermercados);
	}
}*/
