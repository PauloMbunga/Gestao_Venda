package com.venda.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.FormaPagamento;
import com.venda.repository.FormaPagamentos;

@FacesConverter(forClass = FormaPagamento.class)

public class FormaPagamentoConverter implements Converter {

	@Inject
	private FormaPagamentos FormaPagamentos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		FormaPagamento retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = FormaPagamentos.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			FormaPagamento formaPagamento = (FormaPagamento) value;
			return formaPagamento.getId() == null ? null : formaPagamento.getId().toString();
		}
		
		return "";
	}

}