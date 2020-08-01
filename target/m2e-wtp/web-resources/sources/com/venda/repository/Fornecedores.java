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

import com.venda.model.Fornecedor;
import com.venda.repository.filter.FornecedorFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Fornecedores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Fornecedor porId(Long id) {
		return this.manager.find(Fornecedor.class, id);
	}
	
	
	public List<Fornecedor> lista_fornecedores() {
		
		return this.manager.createQuery("from Fornecedor", Fornecedor.class)
				.getResultList();
	}

	public Fornecedor guardar(Fornecedor fornecedor) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		fornecedor = manager.merge(fornecedor);
		
		trx.commit();
		
		return fornecedor;
	}


	@Transactional
	public void remover(Fornecedor fornecedor) throws NegocioException {
		try {
			fornecedor = porId(fornecedor.getId());
			manager.remove(fornecedor);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Fornecedor não pode ser excluído.");
		}
	}

	public Fornecedor porNif(String nif) {
		try {
			return manager.createQuery("from Fornecedor where upper(nif) = :nif", Fornecedor.class)
				.setParameter("nif", nif.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Fornecedor> filtrados(FornecedorFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> criteriaQuery = builder.createQuery(Fornecedor.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Fornecedor> FornecedorRoot = criteriaQuery.from(Fornecedor.class);
		
		
		if (StringUtils.isNotBlank(filtro.getNif())) {
			predicates.add(builder.equal(FornecedorRoot.get("nif"), filtro.getNif()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(FornecedorRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(FornecedorRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(FornecedorRoot.get("nome")));
		
		TypedQuery<Fornecedor> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<Fornecedor> porNome(String nome) {
		return this.manager.createQuery("from Fornecedor where upper(nome) like :nome", Fornecedor.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
}
	
