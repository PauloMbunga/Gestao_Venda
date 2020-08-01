package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.TipoCliente;
import com.venda.repository.TipoClientes;

@FacesConverter(forClass = TipoCliente.class)

public class TipoClienteConverter implements Converter {

	@Inject
	private TipoClientes TipoClientes;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoCliente retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = TipoClientes.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TipoCliente tipoCliente = (TipoCliente) value;
			return tipoCliente.getId() == null ? null : tipoCliente.getId().toString();
		}
		
		return "";
	}

}