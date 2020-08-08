package com.venda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Cliente;
import com.venda.model.TipoCliente;
import com.venda.repository.TipoClientes;
import com.venda.service.CadastroClienteService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoClientes tipoClientes;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	private Cliente cliente;
	
	private List<TipoCliente> listaTipoClientes;
	
	
	
	public CadastroClienteBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.cliente == null) {
			limpar();
		}
		
		listaTipoClientes = tipoClientes.lista_tipoClientes();
	}
	
	
	
	private void limpar() {
		cliente = new Cliente();
		
		listaTipoClientes = new ArrayList<>();
		
	}
	
	public void salvar() {
		
		try {
			
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();
		
		FacesUtil.addInfoMessage("Cliente salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}
	
	public List<TipoCliente> getListaTipoClientes() {
		return listaTipoClientes;
	}
	

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
	}
	
	public boolean isEditando() {
		return this.cliente.getId() != null;
	}

}
