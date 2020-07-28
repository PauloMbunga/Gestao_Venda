package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.venda.model.Loja;

//import com.venda.util.jpa.Transactional;
import com.venda.repository.Lojas;

public class CadastroLojaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Lojas lojas;
	

	public Loja salvar(Loja loja) throws NegocioException {
		
		
		return lojas.guardar(loja);
	}
	
	
}