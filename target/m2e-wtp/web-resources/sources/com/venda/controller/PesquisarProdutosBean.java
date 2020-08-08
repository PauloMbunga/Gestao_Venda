package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Produto;
import com.venda.repository.Produtos;
import com.venda.repository.filter.ProdutoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos Produtos;
	
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	
	private Produto ProdutoSelecionado;
	
	public PesquisarProdutosBean() { 
		
		filtro = new ProdutoFilter();
	} 
	
	public void excluir() {
		try {
			Produtos.remover(ProdutoSelecionado);
			produtosFiltrados.remove(ProdutoSelecionado);
			
			FacesUtil.addInfoMessage("Produto " + ProdutoSelecionado.getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		produtosFiltrados = Produtos.filtrados(filtro);
	
		}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return ProdutoSelecionado;
	}

	public void setProdutoSelecionado(Produto ProdutoSelecionado) {
		this.ProdutoSelecionado = ProdutoSelecionado;
	}
	
}
