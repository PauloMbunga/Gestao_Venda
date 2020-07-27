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

import com.venda.model.Empresa;
import com.venda.repository.filter.EmpresaFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Empresa porId(Long id) {
		return this.manager.find(Empresa.class, id);
	}
	
	
	public List<Empresa> empresas() {
		
		return this.manager.createQuery("from Empresa", Empresa.class)
				.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		empresa = manager.merge(empresa);
		
		trx.commit();
		
		return empresa;
	}


	@Transactional
	public void remover(Empresa Empresa) throws NegocioException {
		try {
			Empresa = porId(Empresa.getId());
			manager.remove(Empresa);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Empresa não pode ser excluído.");
		}
	}

	public Empresa porNif(String nif) {
		try {
			return manager.createQuery("from Empresa where upper(nif) = :nif", Empresa.class)
				.setParameter("nif", nif.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Empresa> filtrados(EmpresaFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Empresa> criteriaQuery = builder.createQuery(Empresa.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Empresa> EmpresaRoot = criteriaQuery.from(Empresa.class);
		////categoriaJoin.fetch("categoriaPai", JoinType.INNER);
		
		if (StringUtils.isNotBlank(filtro.getNif())) {
			predicates.add(builder.equal(EmpresaRoot.get("nif"), filtro.getNif()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(EmpresaRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(EmpresaRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(EmpresaRoot.get("nome")));
		
		TypedQuery<Empresa> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<Empresa> porNome(String nome) {
		return this.manager.createQuery("from Empresa where upper(nome) like :nome", Empresa.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
}
	
