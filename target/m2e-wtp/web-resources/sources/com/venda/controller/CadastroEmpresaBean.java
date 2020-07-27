package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Empresa;
import com.venda.service.CadastroEmpresaService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEmpresaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;
	private Empresa empresa;
	
	
	
	public CadastroEmpresaBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.empresa == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		empresa = new Empresa();
		
	}
	
	public void salvar() {
		
		try {
			
		this.empresa = cadastroEmpresaService.salvar(this.empresa);
		limpar();
		
		FacesUtil.addInfoMessage("Empresa salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
		
	}
	
	public boolean isEditando() {
		return this.empresa.getId() != null;
	}

}
