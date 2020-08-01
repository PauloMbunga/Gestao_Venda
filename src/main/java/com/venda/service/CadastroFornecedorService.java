package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.Fornecedor;
import com.venda.repository.Fornecedores;
//import com.venda.util.jpa.Transactional;

public class CadastroFornecedorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Fornecedores fornecedores;
	
//	public Fornecedor salvar(Fornecedor fornecedor) {
//		
//		return fornecedors.guardar(fornecedor);
//	}
	
	

	public Fornecedor salvar(Fornecedor fornecedor) throws NegocioException {
		//Fornecedor produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return fornecedores.guardar(fornecedor);
	}
	
	
}