package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.FormaPagamento;
import com.venda.service.CadastroFormaPagamentoService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFormaPagamentoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	private FormaPagamento formaPagamento;
	
	
	
	public CadastroFormaPagamentoBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.formaPagamento == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		formaPagamento = new FormaPagamento();
		
	}
	
	public void salvar() {
		
		try {
			
		this.formaPagamento = cadastroFormaPagamentoService.salvar(this.formaPagamento);
		limpar();
		
		FacesUtil.addInfoMessage("Forma de Pagamento salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
		
	}
	
	public boolean isEditando() {
		return this.formaPagamento.getId() != null;
	}

}
