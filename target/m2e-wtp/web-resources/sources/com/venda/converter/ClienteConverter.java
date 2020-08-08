package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Cliente;
import com.venda.repository.Clientes;

@FacesConverter(forClass = Cliente.class)

public class ClienteConverter implements Converter {

	@Inject
	private Clientes Clientes;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = Clientes.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cliente Cliente = (Cliente) value;
			return Cliente.getId() == null ? null : Cliente.getId().toString();
		}
		
		return "";
	}

}