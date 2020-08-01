package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.TipoCliente;
import com.venda.service.CadastroTipoClienteService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTipoClienteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTipoClienteService cadastroTipoClienteService;
	private TipoCliente tipoCliente;
	
	
	
	public CadastroTipoClienteBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.tipoCliente == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		tipoCliente = new TipoCliente();
		
	}
	
	public void salvar() {
		
		try {
			
		this.tipoCliente = cadastroTipoClienteService.salvar(this.tipoCliente);
		limpar();
		
		FacesUtil.addInfoMessage("Tipo de Cliente salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
		
	}
	
	public boolean isEditando() {
		return this.tipoCliente.getId() != null;
	}

}
