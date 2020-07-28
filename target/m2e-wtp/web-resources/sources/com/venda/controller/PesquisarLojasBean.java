package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Loja;
import com.venda.repository.Lojas;
import com.venda.repository.filter.LojaFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarLojasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Lojas Lojas;
	
	private LojaFilter filtro;
	private List<Loja> LojasFiltrados;
	
	private Loja LojaSelecionado;
	
	public PesquisarLojasBean() { 
		
		filtro = new LojaFilter();
	} 
	
	public void excluir() {
		try {
			Lojas.remover(LojaSelecionado);
			LojasFiltrados.remove(LojaSelecionado);
			
			FacesUtil.addInfoMessage("Loja " + LojaSelecionado.getNome()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		LojasFiltrados = Lojas.filtrados(filtro);
	
		}
	
	public List<Loja> getLojasFiltrados() {
		return LojasFiltrados;
	}

	public LojaFilter getFiltro() {
		return filtro;
	}

	public Loja getLojaSelecionado() {
		return LojaSelecionado;
	}

	public void setLojaSelecionado(Loja LojaSelecionado) {
		this.LojaSelecionado = LojaSelecionado;
	}
	
}
