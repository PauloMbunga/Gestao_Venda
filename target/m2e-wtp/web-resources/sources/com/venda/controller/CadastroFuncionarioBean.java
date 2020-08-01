package com.venda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Loja;
import com.venda.model.Funcionario;
import com.venda.repository.Lojas;
import com.venda.service.CadastroFuncionarioService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;



@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Lojas lojas;
	
	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;
	
	private Funcionario funcionario;
	
	
	private List<Loja> listaLojas;
	

	
	public CadastroFuncionarioBean() {
		limpar();
	}
	
	public void inicializar() {
		if (this.funcionario == null) {
			limpar();
		}
		
		listaLojas = lojas.lista_lojas();
		

	}
	
	
	
	private void limpar() {
		funcionario = new Funcionario();
		listaLojas = new ArrayList<>();
		
	}
	
	public void salvar() {
		try {
			this.funcionario = cadastroFuncionarioService.salvar(this.funcionario);
			limpar();
			
			FacesUtil.addInfoMessage("Funcionario salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		
		
	}

	public List<Loja> getListaLojas() {
		return listaLojas;
	}

	
	public boolean isEditando() {
		return this.funcionario.getId() != null;
	}

}