package com.venda.repository.filter;

import java.io.Serializable;
import java.util.Date;



public class EstoqueFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricaoProduto;
	
	

	 public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	private Date data_compra;

	public Date getData_compra() {
		return data_compra;
	}

	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}

	
	

	

	
	

}