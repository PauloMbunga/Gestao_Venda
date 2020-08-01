package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.UnidadeProduto;
import com.venda.repository.UnidadeProdutos;
//import com.venda.util.jpa.Transactional;

public class CadastroUnidadeProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UnidadeProdutos unidadeProdutos;
	

	
	

	public UnidadeProduto salvar(UnidadeProduto unidadeProduto) throws NegocioException {
		//UnidadeProduto produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return unidadeProdutos.guardar(unidadeProduto);
	}
	
	
}