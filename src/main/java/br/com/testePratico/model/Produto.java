package br.com.testePratico.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "TIPO", nullable = false)
	private String tipo;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "MARCA", nullable = false)
	private String marca;
	
	@Column(name = "VALOR", nullable = false)
	private Integer valor;
	
	@Column(name = "DATAVALIDADE", nullable = false)
	private LocalDate dataValidade;
	
	@Column(name = "STATUSCONSUMO", nullable = false)
	private Long statusConsumo;
	
	@ManyToOne
	@JoinColumn(name = "COMPRA_ID")
	private Compra compra;
	
	public Produto() {
		
	}
	
	public Produto(Long id, String tipo, String nome, String marca, Integer valor, LocalDate dataValidade,
			Long statusConsumo, Compra compra) {
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

}
