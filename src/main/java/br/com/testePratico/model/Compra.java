package br.com.testePratico.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "DATACOMPRA", nullable = false)
	private LocalDate dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "SUPERMECADO_ID")
	private Supermercado supermacado;
	
	@OneToMany(mappedBy = "compra")
	private List<Produto> produtos;
	
	@Column(name = "VALORCOMPRA")
	private Integer valorCompra;
	
	private int inativo;
		
	public Compra() {
		
	}

	public Compra(Long id, LocalDate dataCompra, Supermercado supermacado, Integer valorCompra, int inativo) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.supermacado = supermacado;
		this.valorCompra = valorCompra;
		this.inativo = inativo;
	}	
}
