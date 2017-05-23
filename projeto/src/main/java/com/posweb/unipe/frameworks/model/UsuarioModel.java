package com.posweb.unipe.frameworks.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id")
	private int id;
	@Column(name = "email")
	@Email(message = "*Insira um email valido")
	@NotEmpty(message = "*Insira um email")
	private String email;
	@Column(name = "senha")
	@Length(min = 5, message = "*Sua senha precisa ter 5 caracteres")
	@NotEmpty(message = "*Por favor insira a sua senha")
	@Transient
	private String senha;
	@Column(name = "nome")
	@NotEmpty(message = "*Insira um Nome")
	private String nome;
	@Column(name = "sobre_nome")
	@NotEmpty(message = "*Insira um Sobrenome")
	private String sobreNome;
	@Column(name = "active")
	private int active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_funcao", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "funcao_id"))
	private Set<FuncaoModel> funcoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsenha() {
		return senha;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getsobreNome() {
		return sobreNome;
	}

	public void setsobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<FuncaoModel> getfuncoes() {
		return funcoes;
	}

	public void setfuncoes(Set<FuncaoModel> funcoes) {
		this.funcoes = funcoes;
	}

}
