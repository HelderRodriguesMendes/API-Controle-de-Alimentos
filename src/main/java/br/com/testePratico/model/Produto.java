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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode(of = { "id" })
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(name = "TIPO", nullable = false)
	private String tipo;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "MARCA", nullable = false)
	private String marca;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	
	@Column(name = "DATAVALIDADE", nullable = false)
	private LocalDate dataValidade;
	
	@Column(name = "STATUSCONSUMO", nullable = false)
	private Long statusConsumo;
	
	 @JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "COMPRAID")
	private Compra compra;


	public Produto() {
		
	}
}
