package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.Produto;
import com.venda.repository.Produtos;
//import com.venda.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
		

	public Produto salvar(Produto produto) throws NegocioException {
		//Produto produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		
		return produtos.guardar(produto);
	}
	
	
}