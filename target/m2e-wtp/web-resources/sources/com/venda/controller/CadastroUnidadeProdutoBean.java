package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.UnidadeProduto;
import com.venda.service.CadastroUnidadeProdutoService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUnidadeProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroUnidadeProdutoService cadastroUnidadeProdutoService;
	private UnidadeProduto unidadeProduto;
	
	
	
	public CadastroUnidadeProdutoBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.unidadeProduto == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		unidadeProduto = new UnidadeProduto();
		
	}
	
	public void salvar() {
		
		try {
			
		this.unidadeProduto = cadastroUnidadeProdutoService.salvar(this.unidadeProduto);
		limpar();
		
		FacesUtil.addInfoMessage("Forma de Pagamento salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public UnidadeProduto getUnidadeProduto() {
		return unidadeProduto;
	}
	
	public void setUnidadeProduto(UnidadeProduto unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
		
	}
	
	public boolean isEditando() {
		return this.unidadeProduto.getId() != null;
	}

}
