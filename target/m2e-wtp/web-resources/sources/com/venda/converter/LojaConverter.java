package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Loja;
import com.venda.repository.Lojas;

@FacesConverter(forClass = Loja.class)

public class LojaConverter implements Converter {

	@Inject
	private Lojas lojas;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Loja retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = lojas.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Loja loja = (Loja) value;
			return loja.getId() == null ? null : loja.getId().toString();
		}
		
		return "";
	}

}