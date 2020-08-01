package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.FormaPagamento;
import com.venda.repository.FormaPagamentos;
//import com.venda.util.jpa.Transactional;

public class CadastroFormaPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FormaPagamentos formaPagamentos;
	

	
	

	public FormaPagamento salvar(FormaPagamento formaPagamento) throws NegocioException {
		//FormaPagamento produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return formaPagamentos.guardar(formaPagamento);
	}
	
	
}