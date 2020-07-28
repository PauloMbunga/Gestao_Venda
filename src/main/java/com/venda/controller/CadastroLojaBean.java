package com.venda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Empresa;
import com.venda.model.Loja;
import com.venda.repository.Empresas;
import com.venda.service.CadastroLojaService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;



@Named
@ViewScoped
public class CadastroLojaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Inject
	private CadastroLojaService cadastroLojaService;
	
	private Loja loja;
	
	
	private List<Empresa> listaEmpresas;
	

	
	public CadastroLojaBean() {
		limpar();
	}
	
	public void inicializar() {
		if (this.loja == null) {
			limpar();
		}
		
		listaEmpresas = empresas.lista_empresas();
		

	}
	
	
	
	private void limpar() {
		loja = new Loja();
		listaEmpresas = new ArrayList<>();
		
	}
	
	public void salvar() {
		try {
			this.loja = cadastroLojaService.salvar(this.loja);
			limpar();
			
			FacesUtil.addInfoMessage("Loja salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	public Loja getLoja() {
		return loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
		
		
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	
	public boolean isEditando() {
		return this.loja.getId() != null;
	}

}