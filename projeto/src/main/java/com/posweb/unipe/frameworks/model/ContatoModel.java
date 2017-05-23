package com.posweb.unipe.frameworks.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;

 
@Entity(name = "tb_contato")
public class ContatoModel implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
     
    @Column(nullable = false, length = 50)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;
     
    @Column(nullable = false, length = 50)
    @NotBlank(message = "Sobrenome é uma informação obrigatória.")
    private String sobrenome;
     
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Telefone é uma informação obrigatória.")
    private String telefone;
     
    @Column(nullable = false, length = 100)
    @NotBlank(message = "E-mail é uma informação obrigatória.")
    private String email;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    	
}