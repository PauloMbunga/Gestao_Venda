package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.venda.model.Estoque;

//import com.venda.util.jpa.Transactional;
import com.venda.repository.Estoques;

public class CadastroEstoqueService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Estoques estoques;
	

	public Estoque salvar(Estoque estoque) throws NegocioException {
		
		
		return estoques.guardar(estoque);
	}
	
	
}