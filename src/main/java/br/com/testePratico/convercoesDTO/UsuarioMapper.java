package br.com.testePratico.convercoesDTO;

import org.modelmapper.ModelMapper;

import br.com.testePratico.model.Usuario;
import br.com.testePratico.modelDTO.UsuarioDTO;

public class UsuarioMapper {
	
	ModelMapper mapper = new ModelMapper();
	
	public UsuarioDTO toDTO(Usuario usuario) {
		return mapper.map(usuario, UsuarioDTO.class);
	}
	
	public Usuario toEntity(UsuarioDTO usuarioDTO) {
		return mapper.map(usuarioDTO, Usuario.class);
	}

}
