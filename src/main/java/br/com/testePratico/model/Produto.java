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

@Entity
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
	private Integer valor;
	
	@Column(name = "DATAVALIDADE", nullable = false)
	private LocalDate dataValidade;
	
	@Column(name = "STATUSCONSUMO", nullable = false)
	private Long statusConsumo;
	
	@ManyToOne()
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

	public Long getStatusConsumo() {
		return statusConsumo;
	}

	public void setStatusConsumo(Long statusConsumo) {
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
