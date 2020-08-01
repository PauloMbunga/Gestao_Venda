package com.venda.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.venda.model.Funcionario;

//import com.venda.util.jpa.Transactional;
import com.venda.repository.Funcionarios;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios funcionarios;
	

	public Funcionario salvar(Funcionario funcionario) throws NegocioException {
		
		
		return funcionarios.guardar(funcionario);
	}
	
	
}