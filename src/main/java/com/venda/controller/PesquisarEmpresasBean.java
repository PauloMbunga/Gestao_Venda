package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Empresa;
import com.venda.repository.Empresas;
import com.venda.repository.filter.EmpresaFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas Empresas;
	
	private EmpresaFilter filtro;
	private List<Empresa> empresasFiltrados;
	
	private Empresa EmpresaSelecionado;
	
	public PesquisarEmpresasBean() { 
		
		filtro = new EmpresaFilter();
	} 
	
	public void excluir() {
		try {
			Empresas.remover(EmpresaSelecionado);
			empresasFiltrados.remove(EmpresaSelecionado);
			
			FacesUtil.addInfoMessage("Empresa " + EmpresaSelecionado.getNif()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		empresasFiltrados = Empresas.filtrados(filtro);
	
		}
	
	public List<Empresa> getEmpresasFiltrados() {
		return empresasFiltrados;
	}

	public EmpresaFilter getFiltro() {
		return filtro;
	}

	public Empresa getEmpresaSelecionado() {
		return EmpresaSelecionado;
	}

	public void setEmpresaSelecionado(Empresa EmpresaSelecionado) {
		this.EmpresaSelecionado = EmpresaSelecionado;
	}
	
}
