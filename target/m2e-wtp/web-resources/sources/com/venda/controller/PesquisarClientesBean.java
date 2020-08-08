package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Cliente;
import com.venda.repository.Clientes;
import com.venda.repository.filter.ClienteFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarClientesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Clientes Clientes;
	
	private ClienteFilter filtro;
	private List<Cliente> clientesFiltrados;
	
	private Cliente ClienteSelecionado;
	
	public PesquisarClientesBean() { 
		
		filtro = new ClienteFilter();
	} 
	
	public void excluir() {
		try {
			Clientes.remover(ClienteSelecionado);
			clientesFiltrados.remove(ClienteSelecionado);
			
			FacesUtil.addInfoMessage("Cliente " + ClienteSelecionado.getNif()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		clientesFiltrados = Clientes.filtrados(filtro);
	
		}
	
	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

	public ClienteFilter getFiltro() {
		return filtro;
	}

	public Cliente getClienteSelecionado() {
		return ClienteSelecionado;
	}

	public void setClienteSelecionado(Cliente ClienteSelecionado) {
		this.ClienteSelecionado = ClienteSelecionado;
	}
	
}
