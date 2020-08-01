package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.GrupoProduto;
import com.venda.repository.GrupoProdutos;
//import com.venda.util.jpa.Transactional;

public class CadastroGrupoProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoProdutos grupoProdutos;
	

	
	

	public GrupoProduto salvar(GrupoProduto grupoProduto) throws NegocioException {
		//GrupoProduto produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return grupoProdutos.guardar(grupoProduto);
	}
	
	
}