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

import com.venda.model.Cliente;
import com.venda.repository.filter.ClienteFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Cliente porId(Long id) {
		return this.manager.find(Cliente.class, id);
	}
	
	
	public List<Cliente> lista_clientes() {
		
		return this.manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}

	public Cliente guardar(Cliente cliente) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		cliente = manager.merge(cliente);
		
		trx.commit();
		
		return cliente;
	}


	@Transactional
	public void remover(Cliente cliente) throws NegocioException {
		try {
			cliente = porId(cliente.getId());
			manager.remove(cliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Cliente não pode ser excluído.");
		}
	}

	public Cliente porNif(String nif) {
		try {
			return manager.createQuery("from Cliente where upper(nif) = :nif", Cliente.class)
				.setParameter("nif", nif.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Cliente> filtrados(ClienteFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Cliente> ClienteRoot = criteriaQuery.from(Cliente.class);
		
		
		if (StringUtils.isNotBlank(filtro.getNif())) {
			predicates.add(builder.equal(ClienteRoot.get("nif"), filtro.getNif()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(ClienteRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(ClienteRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(ClienteRoot.get("nome")));
		
		TypedQuery<Cliente> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<Cliente> porNome(String nome) {
		return this.manager.createQuery("from Cliente where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
}
	
