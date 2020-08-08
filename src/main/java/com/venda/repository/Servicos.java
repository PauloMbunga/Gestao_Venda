package com.venda.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Fetch;
//import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Servico;
import com.venda.repository.filter.ServicoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Servico porId(Long id) {
		return this.manager.find(Servico.class, id);
	}
	
	
	public List<Servico> lista_servicos() {
		
		return this.manager.createQuery("from Servico", Servico.class)
				.getResultList();
	}

	public Servico guardar(Servico servico) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		servico = manager.merge(servico);
		
		trx.commit();
		
		return servico;
	}


	@Transactional
	public void remover(Servico servico) throws NegocioException {
		try {
			servico = porId(servico.getId());
			manager.remove(servico);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Servico não pode ser excluído.");
		}
	}

	public Servico porCodigo_interno(String codigo_interno) {
		try {
			return manager.createQuery("from Servico where upper(codigo_interno) = :codigo_interno", Servico.class)
				.setParameter("codigo_interno", codigo_interno.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Servico> filtrados(ServicoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Servico> criteriaQuery = builder.createQuery(Servico.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Servico> ServicoRoot = criteriaQuery.from(Servico.class);
		
		
		if (StringUtils.isNotBlank(filtro.getCodigo_interno())) {
			predicates.add(builder.equal(ServicoRoot.get("codigo_interno"), filtro.getCodigo_interno()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			predicates.add(builder.like(builder.lower(ServicoRoot.get("descricao")), 
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(ServicoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(ServicoRoot.get("descricao")));
		
		TypedQuery<Servico> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<Servico> porDescricao(String descricao) {
		return this.manager.createQuery("from Servico where upper(descricao) like :descricao", Servico.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
	
}
	
