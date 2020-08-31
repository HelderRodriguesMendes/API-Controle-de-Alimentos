package br.com.testePratico.modelDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "id" })
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
	
	@Valid
	private List<ProdutoDTO> produtosDTO = new ArrayList<>();
	
	
	private int inativo;
	
	public CompraDTO() {
		
	}
}
