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

import com.venda.model.Produto;
import com.venda.repository.filter.ProdutoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Produto porId(Long id) {
		return this.manager.find(Produto.class, id);
	}
	
	
	public List<Produto> lista_produtos() {
		
		return this.manager.createQuery("from Produto", Produto.class)
				.getResultList();
	}
	

	public Produto guardar(Produto servico) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		servico = manager.merge(servico);
		
		trx.commit();
		
		return servico;
	}


	@Transactional
	public void remover(Produto servico) throws NegocioException {
		try {
			servico = porId(servico.getId());
			manager.remove(servico);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído.");
		}
	}

	public Produto porCodigo_interno(String codigo_interno) {
		try {
			return manager.createQuery("from Produto where upper(codigo_interno) = :codigo_interno", Produto.class)
				.setParameter("codigo_interno", codigo_interno.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Produto> filtrados(ProdutoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Produto> ProdutoRoot = criteriaQuery.from(Produto.class);
		
		
		if (StringUtils.isNotBlank(filtro.getCodigo_interno())) {
			predicates.add(builder.equal(ProdutoRoot.get("codigo_interno"), filtro.getCodigo_interno()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			predicates.add(builder.like(builder.lower(ProdutoRoot.get("descricao")), 
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(ProdutoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(ProdutoRoot.get("descricao")));
		
		TypedQuery<Produto> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<Produto> porDescricao(String descricao) {
		return this.manager.createQuery("from Produto where upper(descricao) like :descricao", Produto.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
	
}
	
