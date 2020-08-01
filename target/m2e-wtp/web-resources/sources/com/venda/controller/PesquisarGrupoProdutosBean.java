package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.GrupoProduto;
import com.venda.repository.GrupoProdutos;
import com.venda.repository.filter.GrupoProdutoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarGrupoProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GrupoProdutos GrupoProdutos;
	
	private GrupoProdutoFilter filtro;
	private List<GrupoProduto> grupoProdutosFiltrados;
	
	private GrupoProduto GrupoProdutoSelecionado;
	
	public PesquisarGrupoProdutosBean() { 
		
		filtro = new GrupoProdutoFilter();
	} 
	
	public void excluir() {
		try {
			GrupoProdutos.remover(GrupoProdutoSelecionado);
			grupoProdutosFiltrados.remove(GrupoProdutoSelecionado);
			
			FacesUtil.addInfoMessage("Forma de Pagamento " + GrupoProdutoSelecionado.getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		grupoProdutosFiltrados = GrupoProdutos.filtrados(filtro);
	
		}
	
	public List<GrupoProduto> getGrupoProdutosFiltrados() {
		return grupoProdutosFiltrados;
	}

	public GrupoProdutoFilter getFiltro() {
		return filtro;
	}

	public GrupoProduto getGrupoProdutoSelecionado() {
		return GrupoProdutoSelecionado;
	}

	public void setGrupoProdutoSelecionado(GrupoProduto GrupoProdutoSelecionado) {
		this.GrupoProdutoSelecionado = GrupoProdutoSelecionado;
	}
	
}
