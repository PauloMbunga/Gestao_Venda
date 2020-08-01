package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Fornecedor;
import com.venda.service.CadastroFornecedorService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFornecedorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroFornecedorService cadastroFornecedorService;
	private Fornecedor fornecedor;
	
	
	
	public CadastroFornecedorBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.fornecedor == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		fornecedor = new Fornecedor();
		
	}
	
	public void salvar() {
		
		try {
			
		this.fornecedor = cadastroFornecedorService.salvar(this.fornecedor);
		limpar();
		
		FacesUtil.addInfoMessage("Fornecedor salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		
	}
	
	public boolean isEditando() {
		return this.fornecedor.getId() != null;
	}

}
