package br.com.tiago.exemplosjparest.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7921332958162096854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pessoa")
	private Long id;
	@Column(name = "nome_pessoa")
	private String nome;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.EAGER)
	private Collection<Telefone> telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
}
