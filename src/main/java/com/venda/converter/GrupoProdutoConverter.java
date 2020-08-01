package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.GrupoProduto;
import com.venda.repository.GrupoProdutos;

@FacesConverter(forClass = GrupoProduto.class)

public class GrupoProdutoConverter implements Converter {

	@Inject
	private GrupoProdutos GrupoProdutos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		GrupoProduto retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = GrupoProdutos.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			GrupoProduto grupoProduto = (GrupoProduto) value;
			return grupoProduto.getId() == null ? null : grupoProduto.getId().toString();
		}
		
		return "";
	}

}