package br.com.testePratico.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testePratico.repository.UsuarioRepository;
import br.com.testePratico.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{login}/senha/{senha}")
	public ResponseEntity<String> login(@PathVariable("usuario") String login, @PathVariable("senha") String senha){
		if(!usuarioService.buscar(login, senha)) {
			System.out.println("entro");
			return ResponseEntity.notFound().build(); //ERRO 404
		}
		System.out.println("nao entro");
		Optional<String> body = Optional.of("Acesso altorizado");
		
		return ResponseEntity.ok(body.get());
	}
	
	/*@GetMapping
	public List<Usuario>todos(){
		List<Usuario> user = usuarioRepository.findAll();
		
		return user;
	}*/
	

	
}
