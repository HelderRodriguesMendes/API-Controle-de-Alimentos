package br.com.testePratico.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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
	
	
	@OneToMany( mappedBy = "compra", cascade = {CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REMOVE})
	private List<Produto> produtos;
	
	public Compra() {
		
	}

	public Compra(Long id, LocalDate dataCompra, String supermercado, String telefone, Integer valorCompra, int inativo,
			List<Produto> produtos) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.supermercado = supermercado;
		this.telefone = telefone;
		this.valorCompra = valorCompra;
		this.inativo = inativo;
		this.produtos = produtos;
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

	public int getInativo() {
		return inativo;
	}

	public void setInativo(int inativo) {
		this.inativo = inativo;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
