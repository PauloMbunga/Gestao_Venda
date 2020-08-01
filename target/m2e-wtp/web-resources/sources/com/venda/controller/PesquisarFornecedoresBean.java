package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Fornecedor;
import com.venda.repository.Fornecedores;
import com.venda.repository.filter.FornecedorFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarFornecedoresBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Fornecedores Fornecedores;
	
	private FornecedorFilter filtro;
	private List<Fornecedor> fornecedoresFiltrados;
	
	private Fornecedor FornecedorSelecionado;
	
	public PesquisarFornecedoresBean() { 
		
		filtro = new FornecedorFilter();
	} 
	
	public void excluir() {
		try {
			Fornecedores.remover(FornecedorSelecionado);
			fornecedoresFiltrados.remove(FornecedorSelecionado);
			
			FacesUtil.addInfoMessage("Fornecedor " + FornecedorSelecionado.getNif()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		fornecedoresFiltrados = Fornecedores.filtrados(filtro);
	
		}
	
	public List<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}

	public FornecedorFilter getFiltro() {
		return filtro;
	}

	public Fornecedor getFornecedorSelecionado() {
		return FornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Fornecedor FornecedorSelecionado) {
		this.FornecedorSelecionado = FornecedorSelecionado;
	}
	
}
