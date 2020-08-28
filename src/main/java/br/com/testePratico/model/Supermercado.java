/*package br.com.testePratico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public class Supermercado implements Serializable {

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
	
	private int inativo;
	
	
	@JsonBackReference
	@OneToMany(mappedBy = "supermacado")
	private List<Compra> compras = new ArrayList<>();
	
	public Supermercado() {
		
	}

	public Supermercado(Long id, String nome, String telefone, String endereco, int inativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.inativo = inativo;
	}	
}*/
