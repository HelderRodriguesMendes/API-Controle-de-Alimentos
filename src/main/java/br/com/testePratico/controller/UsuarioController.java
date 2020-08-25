package br.com.testePratico.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.testePratico.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ResponseEntity<String> login(@RequestParam String login, @RequestParam String senha){
		if(!usuarioService.buscar(login, senha)) {
			return ResponseEntity.notFound().build(); //ERRO 404
		}else {
			Optional<String> body = Optional.of("Acesso altorizado");
			
			return ResponseEntity.ok(body.get());
		}
		
	}
}
