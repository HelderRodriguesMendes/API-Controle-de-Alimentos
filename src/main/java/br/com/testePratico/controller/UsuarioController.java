package br.com.testePratico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.testePratico.model.Usuario;
import br.com.testePratico.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ResponseEntity<Usuario> login(@RequestParam String login, @RequestParam String senha){
		
		System.out.println("VEIO");
		
		Usuario usuario = new Usuario();
		
		if(!usuarioService.buscar(login, senha)) {
			usuario.setLogin("Login ou senha incorretos");
			return ResponseEntity.ok(usuario);
		}else {
			usuario.setLogin("Acesso altorizado");
			return ResponseEntity.ok(usuario);
		}
		
	}
}
