package br.com.testePratico.modelDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.testePratico.model.Compra;
import lombok.Data;

@Data
public class ProdutoDTO {

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório do campo TIPO")
	@Length(min = 4, max = 40, message = "O campo TIPO deve conter entre 4 e 40 caracteres")
	private String tipo;

	@NotEmpty(message = "Preenchimento obrigatório do campo NOME")
	@Length(min = 4, max = 40, message = "O campo NOME deve conter entre 4 e 40 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório do campo MARCA")
	@Length(min = 4, max = 20, message = "O campo NOME deve conter entre 4 e 20 caracteres")
	private String marca;

	@NotEmpty(message = "Preenchimento obrigatório do campo VALOR")
	private Integer valor;

	@NotEmpty(message = "Preenchimento obrigatório do campo DATA DE VALIDADE")
	@DateTimeFormat
	private LocalDate dataValidade;

	@NotEmpty()
	private int statusConsumo;

	private Compra compra;
	
	private int inativo;

	public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String tipo, String nome, String marca, Integer valor, LocalDate dataValidade,
			int statusConsumo, Compra compra, int inativo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		this.dataValidade = dataValidade;
		this.statusConsumo = statusConsumo;
		this.compra = compra;
		this.inativo = inativo;
	}
}
