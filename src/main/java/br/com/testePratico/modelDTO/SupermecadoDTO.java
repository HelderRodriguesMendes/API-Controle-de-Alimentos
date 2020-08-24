package br.com.testePratico.modelDTO;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.testePratico.model.Compra;
import lombok.Data;

@Data
public class SupermecadoDTO {

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório do campo NOME")
	@Length(min = 4, max = 40, message = "O campo NOME deve conter entre 4 e 40 caracteres")
	private String nome;

	@Length(max = 20, message = "O campo TELEFONE deve conter no máximo 20 caracteres")
	private String telefone;

	@Length(max = 50, message = "O campo ENDEREÇO deve conter no máximo 50 caracteres")
	private String endereco;

	private List<Compra> compras;

	public SupermecadoDTO() {

	}

	public SupermecadoDTO(Long id, String nome, String telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
}
