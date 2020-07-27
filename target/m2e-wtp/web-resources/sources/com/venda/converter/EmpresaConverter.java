package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Empresa;
import com.venda.repository.Empresas;

@FacesConverter(forClass = Empresa.class)

public class EmpresaConverter implements Converter {

	@Inject
	private Empresas Empresas;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Empresa retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = Empresas.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Empresa Empresa = (Empresa) value;
			return Empresa.getId() == null ? null : Empresa.getId().toString();
		}
		
		return "";
	}

}