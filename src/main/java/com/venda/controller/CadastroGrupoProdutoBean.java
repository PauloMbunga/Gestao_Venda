package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.GrupoProduto;
import com.venda.service.CadastroGrupoProdutoService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroGrupoProdutoService cadastroGrupoProdutoService;
	private GrupoProduto grupoProduto;
	
	
	
	public CadastroGrupoProdutoBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.grupoProduto == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		grupoProduto = new GrupoProduto();
		
	}
	
	public void salvar() {
		
		try {
			
		this.grupoProduto = cadastroGrupoProdutoService.salvar(this.grupoProduto);
		limpar();
		
		FacesUtil.addInfoMessage("Forma de Pagamento salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}
	
	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
		
	}
	
	public boolean isEditando() {
		return this.grupoProduto.getId() != null;
	}

}
