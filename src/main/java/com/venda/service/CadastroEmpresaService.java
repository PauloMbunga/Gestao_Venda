package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.venda.model.Empresa;
import com.venda.repository.Empresas;
//import com.venda.util.jpa.Transactional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
//	public Empresa salvar(Empresa empresa) {
//		
//		return empresas.guardar(empresa);
//	}
	
	

	public Empresa salvar(Empresa empresa) throws NegocioException {
		//Empresa produtoExistente = produtos.porSku(produto.getSku());
		
//		if (produtoExistente != null && !produtoExistente.equals(produto)) {
//			throw new NegocioException("Já existe um produto com o SKU informado.");
//		}
		
		return empresas.guardar(empresa);
	}
	
	
}