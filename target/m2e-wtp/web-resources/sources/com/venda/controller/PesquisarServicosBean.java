package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.venda.model.Servico;
import com.venda.repository.Servicos;
import com.venda.repository.filter.ServicoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarServicosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Servicos Servicos;
	
	private ServicoFilter filtro;
	private List<Servico> servicosFiltrados;
	
	private Servico ServicoSelecionado;
	
	public PesquisarServicosBean() { 
		
		filtro = new ServicoFilter();
	} 
	
	public void excluir() {
		try {
			Servicos.remover(ServicoSelecionado);
			servicosFiltrados.remove(ServicoSelecionado);
			
			FacesUtil.addInfoMessage("Servico " + ServicoSelecionado.getDescricao()
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}
	
	public void pesquisar() {
		
		
		servicosFiltrados = Servicos.filtrados(filtro);
	
		}
	
	public List<Servico> getServicosFiltrados() {
		return servicosFiltrados;
	}

	public ServicoFilter getFiltro() {
		return filtro;
	}

	public Servico getServicoSelecionado() {
		return ServicoSelecionado;
	}

	public void setServicoSelecionado(Servico ServicoSelecionado) {
		this.ServicoSelecionado = ServicoSelecionado;
	}
	
}
