package com.posweb.unipe.frameworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcao")
public class FuncaoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="funcao_id")
	private int id;
	@Column(name="funcao")
	private String funcao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfuncao() {
		return funcao;
	}
	public void setfuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
}
