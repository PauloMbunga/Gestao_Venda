package com.venda.repository.filter;

import java.io.Serializable;
import java.util.Date;


public class FuncionarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Date  data_nascimento;

	

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	

}