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

import com.venda.model.Loja;
import com.venda.repository.filter.LojaFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Lojas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Loja porId(Long id) {
		return this.manager.find(Loja.class, id);
	}
	
	
	public List<Loja> lista_lojas() {
		
		return this.manager.createQuery("from Loja", Loja.class)
				.getResultList();
	}

	public Loja guardar(Loja loja) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		loja = manager.merge(loja);
		
		trx.commit();
		
		return loja;
	}


	@Transactional
	public void remover(Loja loja) throws NegocioException {
		try {
			loja = porId(loja.getId());
			manager.remove(loja);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Loja não pode ser excluído.");
		}
	}

//	public Empresa porNif(String nif) {
//		try {
//			return manager.createQuery("from Empresa where upper(nif) = :nif", Empresa.class)
//				.setParameter("nif", nif.toUpperCase())
//				.getSingleResult();
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
//	

	
	
	public List<Loja> filtrados(LojaFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Loja> criteriaQuery = builder.createQuery(Loja.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Loja> lojaRoot = criteriaQuery.from(Loja.class);
		
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(lojaRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(lojaRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(lojaRoot.get("nome")));
		
		TypedQuery<Loja> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
//	
//	
//
//	public List<Empresa> porNome(String nome) {
//		return this.manager.createQuery("from Empresa where upper(nome) like :nome", Empresa.class)
//				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
//	}
//	
}
	
