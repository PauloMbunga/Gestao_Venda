package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.Servico;
import com.venda.repository.Servicos;
//import com.venda.util.jpa.Transactional;

public class CadastroServicoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Servicos servicos;
		

	public Servico salvar(Servico servico) throws NegocioException {
		//Servico produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		
		return servicos.guardar(servico);
	}
	
	
}