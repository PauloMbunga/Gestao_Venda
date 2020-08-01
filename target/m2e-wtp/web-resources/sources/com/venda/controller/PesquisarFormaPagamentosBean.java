package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.FormaPagamento;
import com.venda.repository.FormaPagamentos;
import com.venda.repository.filter.FormaPagamentoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarFormaPagamentosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FormaPagamentos FormaPagamentos;
	
	private FormaPagamentoFilter filtro;
	private List<FormaPagamento> formaPagamentosFiltrados;
	
	private FormaPagamento FormaPagamentoSelecionado;
	
	public PesquisarFormaPagamentosBean() { 
		
		filtro = new FormaPagamentoFilter();
	} 
	
	public void excluir() {
		try {
			FormaPagamentos.remover(FormaPagamentoSelecionado);
			formaPagamentosFiltrados.remove(FormaPagamentoSelecionado);
			
			FacesUtil.addInfoMessage("Forma de Pagamento " + FormaPagamentoSelecionado.getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		formaPagamentosFiltrados = FormaPagamentos.filtrados(filtro);
	
		}
	
	public List<FormaPagamento> getFormaPagamentosFiltrados() {
		return formaPagamentosFiltrados;
	}

	public FormaPagamentoFilter getFiltro() {
		return filtro;
	}

	public FormaPagamento getFormaPagamentoSelecionado() {
		return FormaPagamentoSelecionado;
	}

	public void setFormaPagamentoSelecionado(FormaPagamento FormaPagamentoSelecionado) {
		this.FormaPagamentoSelecionado = FormaPagamentoSelecionado;
	}
	
}
