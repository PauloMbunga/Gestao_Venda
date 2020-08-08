package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Estoque;
import com.venda.repository.Estoques;
import com.venda.repository.filter.EstoqueFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarEstoquesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estoques Estoques;
	
	private EstoqueFilter filtro;
	private List<Estoque> EstoquesFiltrados;
	
	private Estoque EstoqueSelecionado;
	
	public PesquisarEstoquesBean() { 
		
		filtro = new EstoqueFilter();
	} 
	
	public void excluir() {
		try {
			Estoques.remover(EstoqueSelecionado);
			EstoquesFiltrados.remove(EstoqueSelecionado);
			
			FacesUtil.addInfoMessage("Estoque " + EstoqueSelecionado.getProduto().getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		EstoquesFiltrados = Estoques.filtrados(filtro);
	
		}
	
	public List<Estoque> getEstoquesFiltrados() {
		return EstoquesFiltrados;
	}

	public EstoqueFilter getFiltro() {
		return filtro;
	}

	public Estoque getEstoqueSelecionado() {
		return EstoqueSelecionado;
	}

	public void setEstoqueSelecionado(Estoque EstoqueSelecionado) {
		this.EstoqueSelecionado = EstoqueSelecionado;
	}
	
}
