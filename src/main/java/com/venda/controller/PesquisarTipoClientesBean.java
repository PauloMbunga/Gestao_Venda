package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.TipoCliente;
import com.venda.repository.TipoClientes;
import com.venda.repository.filter.TipoClienteFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarTipoClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoClientes TipoClientes;
	
	private TipoClienteFilter filtro;
	private List<TipoCliente> tipoClientesFiltrados;
	
	private TipoCliente TipoClienteSelecionado;
	
	public PesquisarTipoClientesBean() { 
		
		filtro = new TipoClienteFilter();
	} 
	
	public void excluir() {
		try {
			TipoClientes.remover(TipoClienteSelecionado);
			tipoClientesFiltrados.remove(TipoClienteSelecionado);
			
			FacesUtil.addInfoMessage("Forma de Pagamento " + TipoClienteSelecionado.getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		tipoClientesFiltrados = TipoClientes.filtrados(filtro);
	
		}
	
	public List<TipoCliente> getTipoClientesFiltrados() {
		return tipoClientesFiltrados;
	}

	public TipoClienteFilter getFiltro() {
		return filtro;
	}

	public TipoCliente getTipoClienteSelecionado() {
		return TipoClienteSelecionado;
	}

	public void setTipoClienteSelecionado(TipoCliente TipoClienteSelecionado) {
		this.TipoClienteSelecionado = TipoClienteSelecionado;
	}
	
}
