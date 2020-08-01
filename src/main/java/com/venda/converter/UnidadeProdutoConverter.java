package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.UnidadeProduto;
import com.venda.repository.UnidadeProdutos;

@FacesConverter(forClass = UnidadeProduto.class)

public class UnidadeProdutoConverter implements Converter {

	@Inject
	private UnidadeProdutos UnidadeProdutos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		UnidadeProduto retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = UnidadeProdutos.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			UnidadeProduto unidadeProduto = (UnidadeProduto) value;
			return unidadeProduto.getId() == null ? null : unidadeProduto.getId().toString();
		}
		
		return "";
	}

}