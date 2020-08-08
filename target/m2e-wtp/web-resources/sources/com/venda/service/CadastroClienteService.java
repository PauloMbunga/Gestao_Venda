package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.Cliente;
import com.venda.repository.Clientes;
//import com.venda.util.jpa.Transactional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
//	public Cliente salvar(Cliente cliente) {
//		
//		return clientes.guardar(cliente);
//	}
	
	

	public Cliente salvar(Cliente cliente) throws NegocioException {
		//Cliente produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return clientes.guardar(cliente);
	}
	
	
}