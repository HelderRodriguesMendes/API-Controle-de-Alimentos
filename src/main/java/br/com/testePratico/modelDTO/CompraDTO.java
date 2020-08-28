package br.com.testePratico.modelDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class CompraDTO {

	private Long id;

	@NotNull(message = "Preenchimento obrigatório do campo DATA DA COMPRA")
	@DateTimeFormat
	private LocalDate dataCompra;
	
	@Length(min = 4, max = 40, message = "O campo SUPERMERCADO deve conter entre 4 e 40 caracteres")
	@NotEmpty(message = "Preenchimento obrigatório do campo SUPERMECADO")
	private String supermercado;
	
	@Length(max = 20, message = "O campo TELEFONE deve conter no máximo 20 caracteres")
	private String telefone;
	
	private Integer valorCompra;
	
	
	private List<ProdutoDTO> produtosDTO = new ArrayList<>();
	
	
	private int inativo;
	
	public CompraDTO() {
		
	}

	
	
	public CompraDTO(Long id,
			@NotNull(message = "Preenchimento obrigatório do campo DATA DA COMPRA") LocalDate dataCompra,
			@Length(min = 4, max = 40, message = "O campo SUPERMERCADO deve conter entre 4 e 40 caracteres") @NotEmpty(message = "Preenchimento obrigatório do campo SUPERMECADO") String supermercado,
			@Length(max = 20, message = "O campo TELEFONE deve conter no máximo 20 caracteres") String telefone,
			Integer valorCompra, List<ProdutoDTO> produtosDTO, int inativo) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.supermercado = supermercado;
		this.telefone = telefone;
		this.valorCompra = valorCompra;
		this.produtosDTO = produtosDTO;
		this.inativo = inativo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(String supermercado) {
		this.supermercado = supermercado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Integer valorCompra) {
		this.valorCompra = valorCompra;
	}

	public List<ProdutoDTO> getProdutosDTO() {
		return produtosDTO;
	}

	public void setProdutosDTO(List<ProdutoDTO> produtosDTO) {
		this.produtosDTO = produtosDTO;
	}

	public int getInativo() {
		return inativo;
	}

	public void setInativo(int inativo) {
		this.inativo = inativo;
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
		CompraDTO other = (CompraDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
