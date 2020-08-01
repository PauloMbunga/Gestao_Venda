package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Funcionario;
import com.venda.repository.Funcionarios;
import com.venda.repository.filter.FuncionarioFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarFuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios Funcionarios;
	
	private FuncionarioFilter filtro;
	private List<Funcionario> FuncionariosFiltrados;
	
	private Funcionario FuncionarioSelecionado;
	
	public PesquisarFuncionariosBean() { 
		
		filtro = new FuncionarioFilter();
	} 
	
	public void excluir() {
		try {
			Funcionarios.remover(FuncionarioSelecionado);
			FuncionariosFiltrados.remove(FuncionarioSelecionado);
			
			FacesUtil.addInfoMessage("Funcionario " + FuncionarioSelecionado.getNome()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		FuncionariosFiltrados = Funcionarios.filtrados(filtro);
	
		}
	
	public List<Funcionario> getFuncionariosFiltrados() {
		return FuncionariosFiltrados;
	}

	public FuncionarioFilter getFiltro() {
		return filtro;
	}

	public Funcionario getFuncionarioSelecionado() {
		return FuncionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario FuncionarioSelecionado) {
		this.FuncionarioSelecionado = FuncionarioSelecionado;
	}
	
}
