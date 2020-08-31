package br.com.testePratico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testePratico.Exception.RegistroNaoEncontradoException;
import br.com.testePratico.convercoesDTO.UsuarioMapper;
import br.com.testePratico.model.Usuario;
import br.com.testePratico.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	UsuarioMapper uruairoMapper = new UsuarioMapper();
	
	public boolean buscar(String login, String senha) {
		
		String[] l = login.split(",");
		String lo = l[1];
		
		String[] s = senha.split(",");
		String se = s[1];
		
		
		final Long id = (long) 1;
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Usuário não encontrado"));
		
		boolean ok = false;
		
		if(usuario.getLogin().equals(lo) && usuario.getSenha().equals(se)) {	
			ok = true;
		}
		
		return ok;
	}
}
