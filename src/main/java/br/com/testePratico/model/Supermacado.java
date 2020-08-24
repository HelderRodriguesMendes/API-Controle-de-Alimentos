package br.com.testePratico.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Supermacado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "ENDERECO")
	private String endereco;
	
	@OneToMany(mappedBy = "supermacado")
	private List<Compra> compras;
	
	public Supermacado() {
		
	}

	public Supermacado(Long id, String nome, String telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}	
}
