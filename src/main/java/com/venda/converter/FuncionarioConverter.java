package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Funcionario;
import com.venda.repository.Funcionarios;

@FacesConverter(forClass = Funcionario.class)

public class FuncionarioConverter implements Converter {

	@Inject
	private Funcionarios funcionarios;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = funcionarios.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Funcionario funcionario = (Funcionario) value;
			return funcionario.getId() == null ? null : funcionario.getId().toString();
		}
		
		return "";
	}

}