package com.venda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.GrupoProduto;
import com.venda.model.Produto;
import com.venda.repository.GrupoProdutos;
import com.venda.service.CadastroProdutoService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GrupoProdutos grupoProdutos;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	private Produto produto;
	
	private List<GrupoProduto> listaGrupoProdutos;
	
	
	
	public CadastroProdutoBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.produto == null) {
			limpar();
		}
		
		listaGrupoProdutos = grupoProdutos.lista_grupoProdutos();
	}
	
	
	
	private void limpar() {
		produto = new Produto();
		
		listaGrupoProdutos = new ArrayList<>();
		
	}
	
	public void salvar() {
		
		try {
			if(!isEditando()) {
				this.produto.setActivo_para_venda(true);
	
			}
			
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		
		FacesUtil.addInfoMessage("Produto salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}
	
	
	public List<GrupoProduto> getListaGrupoProdutos() {
		return listaGrupoProdutos;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		
	}
	
	public boolean isEditando() {
		return this.produto.getId() != null;
	}

}
