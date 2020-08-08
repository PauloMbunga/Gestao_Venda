package com.venda.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Servico;
import com.venda.service.CadastroServicoService;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroServicoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroServicoService cadastroServicoService;
	private Servico servico;
	
	
	
	public CadastroServicoBean() {
		limpar();
	}
	
	public void inicializar() {

		if (this.servico == null) {
			limpar();
		}
	}
	
	
	
	private void limpar() {
		servico = new Servico();
		
	}
	
	public void salvar() {
		
		try {
			if(!isEditando()) {
				this.servico.setActivo_para_venda(true);
				//System.out.println("Hello World");
			}
			
		this.servico = cadastroServicoService.salvar(this.servico);
		limpar();
		
		FacesUtil.addInfoMessage("Serviço salva com sucesso!");
		
	   } catch (NegocioException ne) {
		FacesUtil.addErrorMessage(ne.getMessage());
	   }
	}

	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
		
	}
	
	public boolean isEditando() {
		return this.servico.getId() != null;
	}

}
