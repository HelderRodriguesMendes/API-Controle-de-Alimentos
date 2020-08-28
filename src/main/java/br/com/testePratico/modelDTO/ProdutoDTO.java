package br.com.testePratico.modelDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.testePratico.model.Compra;

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
	
	public ProdutoDTO() {
		
	}

		
	public ProdutoDTO(Long id,
			@NotEmpty(message = "Preenchimento obrigatório do campo TIPO") @Length(min = 4, max = 40, message = "O campo TIPO deve conter entre 4 e 40 caracteres") String tipo,
			@NotEmpty(message = "Preenchimento obrigatório do campo NOME") @Length(min = 4, max = 40, message = "O campo NOME deve conter entre 4 e 40 caracteres") String nome,
			@NotEmpty(message = "Preenchimento obrigatório do campo MARCA") @Length(min = 4, max = 20, message = "O campo NOME deve conter entre 4 e 20 caracteres") String marca,
			@NotEmpty(message = "Preenchimento obrigatório do campo VALOR") Integer valor,
			@NotEmpty(message = "Preenchimento obrigatório do campo DATA DE VALIDADE") LocalDate dataValidade,
			@NotEmpty int statusConsumo, Compra compra) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.marca = marca;
		this.valor = valor;
		this.dataValidade = dataValidade;
		this.statusConsumo = statusConsumo;
		this.compra = compra;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public int getStatusConsumo() {
		return statusConsumo;
	}

	public void setStatusConsumo(int statusConsumo) {
		this.statusConsumo = statusConsumo;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
