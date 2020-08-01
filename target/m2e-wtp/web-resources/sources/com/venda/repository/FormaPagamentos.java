package com.venda.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Fetch;
//import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.FormaPagamento;
import com.venda.repository.filter.FormaPagamentoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class FormaPagamentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public FormaPagamento porId(Long id) {
		return this.manager.find(FormaPagamento.class, id);
	}
	
	
	public List<FormaPagamento> lista_formaPagamentos() {
		
		return this.manager.createQuery("from FormaPagamento", FormaPagamento.class)
				.getResultList();
	}

	public FormaPagamento guardar(FormaPagamento formaPagamento) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		formaPagamento = manager.merge(formaPagamento);
		
		trx.commit();
		
		return formaPagamento;
	}


	@Transactional
	public void remover(FormaPagamento formaPagamento) throws NegocioException {
		try {
			formaPagamento = porId(formaPagamento.getId());
			manager.remove(formaPagamento);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Forma de Pagamento não pode ser excluído.");
		}
	}

	
	
	public List<FormaPagamento> filtrados(FormaPagamentoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<FormaPagamento> criteriaQuery = builder.createQuery(FormaPagamento.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<FormaPagamento> FormaPagamentoRoot = criteriaQuery.from(FormaPagamento.class);
		
		
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			predicates.add(builder.like(builder.lower(FormaPagamentoRoot.get("descricao")), 
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(FormaPagamentoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(FormaPagamentoRoot.get("descricao")));
		
		TypedQuery<FormaPagamento> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<FormaPagamento> porDescricao(String descricao) {
		return this.manager.createQuery("from FormaPagamento where upper(descricao) like :descricao", FormaPagamento.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
	
}
	
