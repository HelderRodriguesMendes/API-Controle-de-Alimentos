package br.com.testePratico.modelDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.testePratico.model.Compra;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "id" })
public class ProdutoDTO {

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório do campo TIPO")
	@Length(min = 4, max = 40, message = "O campo TIPO deve conter entre 4 e 40 caracteres")
	private String tipo;

	@NotEmpty(message = "Preenchimento obrigatório do campo NOME")
	@Length(min = 1, max = 40, message = "O campo NOME deve conter entre 1 e 40 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório do campo MARCA")
	@Length(min = 1, max = 20, message = "O campo MARCA deve conter entre 4 e 20 caracteres")
	private String marca;

	@NotNull(message = "Preenchimento obrigatório do campo VALOR")
	private Double valor;

	@NotNull(message = "Preenchimento obrigatório do campo DATA DE VALIDADE")
	@DateTimeFormat
	private LocalDate dataValidade;

	private int statusConsumo;
	
	
	private Compra compra;
	
	public ProdutoDTO() {
		
	}
}
