package com.venda.repository.filter;

import java.io.Serializable;


public class FornecedorFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nif;
	private String nome;

	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif == null ? null : nif.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "FornecedorFilter [nif=" + nif + ", nome=" + nome + "]";
	}
	

}