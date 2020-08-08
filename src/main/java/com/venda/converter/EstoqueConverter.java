package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Estoque;
import com.venda.repository.Estoques;

@FacesConverter(forClass = Estoque.class)

public class EstoqueConverter implements Converter {

	@Inject
	private Estoques Estoques;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Estoque retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = Estoques.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Estoque Estoque = (Estoque) value;
			return Estoque.getId() == null ? null : Estoque.getId().toString();
		}
		
		return "";
	}

}