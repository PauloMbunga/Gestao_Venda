package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.UnidadeProduto;
import com.venda.repository.UnidadeProdutos;
import com.venda.repository.filter.UnidadeProdutoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarUnidadeProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UnidadeProdutos UnidadeProdutos;
	
	private UnidadeProdutoFilter filtro;
	private List<UnidadeProduto> unidadeProdutosFiltrados;
	
	private UnidadeProduto UnidadeProdutoSelecionado;
	
	public PesquisarUnidadeProdutosBean() { 
		
		filtro = new UnidadeProdutoFilter();
	} 
	
	public void excluir() {
		try {
			UnidadeProdutos.remover(UnidadeProdutoSelecionado);
			unidadeProdutosFiltrados.remove(UnidadeProdutoSelecionado);
			
			FacesUtil.addInfoMessage("Forma de Pagamento " + UnidadeProdutoSelecionado.getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		unidadeProdutosFiltrados = UnidadeProdutos.filtrados(filtro);
	
		}
	
	public List<UnidadeProduto> getUnidadeProdutosFiltrados() {
		return unidadeProdutosFiltrados;
	}

	public UnidadeProdutoFilter getFiltro() {
		return filtro;
	}

	public UnidadeProduto getUnidadeProdutoSelecionado() {
		return UnidadeProdutoSelecionado;
	}

	public void setUnidadeProdutoSelecionado(UnidadeProduto UnidadeProdutoSelecionado) {
		this.UnidadeProdutoSelecionado = UnidadeProdutoSelecionado;
	}
	
}
