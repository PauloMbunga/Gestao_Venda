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

import com.venda.model.UnidadeProduto;
import com.venda.repository.filter.UnidadeProdutoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class UnidadeProdutos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public UnidadeProduto porId(Long id) {
		return this.manager.find(UnidadeProduto.class, id);
	}
	
	
	public List<UnidadeProduto> lista_unidadeProdutos() {
		
		return this.manager.createQuery("from UnidadeProduto", UnidadeProduto.class)
				.getResultList();
	}

	public UnidadeProduto guardar(UnidadeProduto unidadeProduto) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		unidadeProduto = manager.merge(unidadeProduto);
		
		trx.commit();
		
		return unidadeProduto;
	}


	@Transactional
	public void remover(UnidadeProduto unidadeProduto) throws NegocioException {
		try {
			unidadeProduto = porId(unidadeProduto.getId());
			manager.remove(unidadeProduto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Forma de Pagamento não pode ser excluído.");
		}
	}

	
	
	public List<UnidadeProduto> filtrados(UnidadeProdutoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<UnidadeProduto> criteriaQuery = builder.createQuery(UnidadeProduto.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<UnidadeProduto> UnidadeProdutoRoot = criteriaQuery.from(UnidadeProduto.class);
		
		
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			predicates.add(builder.like(builder.lower(UnidadeProdutoRoot.get("descricao")), 
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(UnidadeProdutoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(UnidadeProdutoRoot.get("descricao")));
		
		TypedQuery<UnidadeProduto> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<UnidadeProduto> porDescricao(String descricao) {
		return this.manager.createQuery("from UnidadeProduto where upper(descricao) like :descricao", UnidadeProduto.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
	
}
	
