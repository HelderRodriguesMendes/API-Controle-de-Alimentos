package br.com.testePratico.modelDTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String senha;
}
