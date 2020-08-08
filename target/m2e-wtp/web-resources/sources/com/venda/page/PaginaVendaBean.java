package com.venda.page;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named
@SessionScoped
public class PaginaVendaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	
	public String paginaVendaBalcao() {
		
		//System.out.println("Hello World Pagina");
	boolean	a =false;
	
	 return  a ? "/dps/FN/vendas/aberturaCaixa.xhtml" : "/dps/FN/vendas/vendaBalcao.xhtml";
		
	}

	

}