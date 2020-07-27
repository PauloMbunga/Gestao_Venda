package com.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.venda.model.Usuario;
import com.venda.util.jsf.FacesUtil;


@Named
@SessionScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	//private Produto produto;
	
	private List<Usuario> categoriasRaizes;
	
	
	public void inicializar() {
		System.out.println("Inicializando...");
		
		if (FacesUtil.isNotPostback()) {
		categoriasRaizes = manager.createQuery("from Usuario", Usuario.class).getResultList();
		}
//		for(int i=0; i<categoriasRaizes.size();i++) {
//			
//			System.out.println(categoriasRaizes.get(i).getNome());
//		}
//		
	}
	
	public void salvar() {
	  int a = 2;	
	System.out.println(a/0);
	}

	

	public List<Usuario> getCategoriasRaizes() {
		return categoriasRaizes;
	}
	
}