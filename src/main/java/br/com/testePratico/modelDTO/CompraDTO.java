package br.com.testePratico.modelDTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.testePratico.model.Produto;
import br.com.testePratico.model.Supermercado;
import lombok.Data;

@Data
public class CompraDTO {

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório do campo DATA DA COMPRA")
	@DateTimeFormat
	private LocalDate dataCompra;

	@NotEmpty(message = "Preenchimento obrigatório do campo SUPERMECADO")
	private Supermercado supermacado;

	private List<Produto> produtos;

	private Integer valorCompra;
	
	private int inativo;

	public CompraDTO() {

	}

	public CompraDTO(Long id, LocalDate dataCompra, Supermercado supermacado, Integer valorCompra, int inativo) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.supermacado = supermacado;
		this.valorCompra = valorCompra;
		this.inativo = inativo;
	}
}
