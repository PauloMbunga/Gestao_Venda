package com.venda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Loja;
import com.venda.model.Produto;
import com.venda.model.UnidadeProduto;
import com.venda.model.Estoque;
import com.venda.model.Fornecedor;
import com.venda.repository.Fornecedores;
import com.venda.repository.Lojas;
import com.venda.repository.Produtos;
import com.venda.repository.UnidadeProdutos;
import com.venda.service.CadastroEstoqueService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;



@Named
@ViewScoped
public class CadastroEstoqueBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Lojas lojas;
	
	@Inject
	private Produtos produtos;
	
	@Inject
	private Fornecedores fornecedores;
	
	@Inject
	private UnidadeProdutos unidadeProdutos;
	
	@Inject
	private CadastroEstoqueService cadastroEstoqueService;
	
	private Estoque estoque;
	
	
	private List<Loja> listaLojas;
	
	private List<Produto> listaProdutos;
	
	private List<Fornecedor> listaFornecedores;
	
	private List<UnidadeProduto> listaUnidadeProdutos;
	

	
	public CadastroEstoqueBean() {
		limpar();
	}
	
	public void inicializar() {
		if (this.estoque == null) {
			limpar();
		}
		
		listaLojas = lojas.lista_lojas();
		listaProdutos = produtos.lista_produtos();
		listaFornecedores = fornecedores.lista_fornecedores();
		listaUnidadeProdutos = unidadeProdutos.lista_unidadeProdutos();
		

	}
	
	
	
	private void limpar() {
		estoque = new Estoque();
		listaLojas = new ArrayList<>();
		listaProdutos = new ArrayList<>();
		listaFornecedores = new ArrayList<>();
		listaUnidadeProdutos = new ArrayList<>();
		
	}
	
	public void salvar() {
		try {
			this.estoque = cadastroEstoqueService.salvar(this.estoque);
			limpar();
			
			FacesUtil.addInfoMessage("Estoque salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	public Estoque getEstoque() {
		return estoque;
	}
	
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
		
		
	}

	public List<Loja> getListaLojas() {
		return listaLojas;
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}
	
	public List<UnidadeProduto> getListaUnidadeProdutos() {
		return listaUnidadeProdutos;
	}

	
	public boolean isEditando() {
		return this.estoque.getId() != null;
	}

}