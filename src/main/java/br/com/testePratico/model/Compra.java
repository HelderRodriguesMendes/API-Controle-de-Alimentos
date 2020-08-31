package br.com.testePratico.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "compra")
@Data
@EqualsAndHashCode(of = { "id" })
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(name = "DATACOMPRA", nullable = false)
	private LocalDate dataCompra;

	@Column(name = "SUPERMERCADO", nullable = false)
	private String supermercado;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "VALORCOMPRA")
	private Integer valorCompra;

	private int inativo;

	@JsonManagedReference
	@OneToMany(mappedBy = "compra")
	private List<Produto> produtos;

	public Compra() {

	}
}
