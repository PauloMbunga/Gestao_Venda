package com.venda.repository.filter;

import java.io.Serializable;
import java.math.BigDecimal;


public class ServicoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private String codigo_interno;
	private BigDecimal valor_custo;
    private BigDecimal valor_venda ;
    private boolean activo_para_venda ;

	
	

	public String getCodigo_interno() {
		return codigo_interno;
	}

	public void setCodigo_interno(String codigo_interno) {
		this.codigo_interno = codigo_interno == null ? null : codigo_interno.toUpperCase();
	}

	public BigDecimal getValor_custo() {
		return valor_custo;
	}

	public void setValor_custo(BigDecimal valor_custo) {
		this.valor_custo = valor_custo;
	}

	public BigDecimal getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
	}

	public boolean isActivo_para_venda() {
		return activo_para_venda;
	}

	public void setActivo_para_venda(boolean activo_para_venda) {
		this.activo_para_venda = activo_para_venda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}