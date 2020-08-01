package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.TipoCliente;
import com.venda.repository.TipoClientes;
//import com.venda.util.jpa.Transactional;

public class CadastroTipoClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoClientes tipoClientes;
	

	
	

	public TipoCliente salvar(TipoCliente tipoCliente) throws NegocioException {
		//TipoCliente produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return tipoClientes.guardar(tipoCliente);
	}
	
	
}