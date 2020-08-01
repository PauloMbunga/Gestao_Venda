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

import com.venda.model.GrupoProduto;
import com.venda.repository.filter.GrupoProdutoFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class GrupoProdutos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public GrupoProduto porId(Long id) {
		return this.manager.find(GrupoProduto.class, id);
	}
	
	
	public List<GrupoProduto> lista_grupoProdutos() {
		
		return this.manager.createQuery("from GrupoProduto", GrupoProduto.class)
				.getResultList();
	}

	public GrupoProduto guardar(GrupoProduto grupoProduto) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		grupoProduto = manager.merge(grupoProduto);
		
		trx.commit();
		
		return grupoProduto;
	}


	@Transactional
	public void remover(GrupoProduto grupoProduto) throws NegocioException {
		try {
			grupoProduto = porId(grupoProduto.getId());
			manager.remove(grupoProduto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Forma de Pagamento não pode ser excluído.");
		}
	}

	
	
	public List<GrupoProduto> filtrados(GrupoProdutoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<GrupoProduto> criteriaQuery = builder.createQuery(GrupoProduto.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<GrupoProduto> GrupoProdutoRoot = criteriaQuery.from(GrupoProduto.class);
		
		
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			predicates.add(builder.like(builder.lower(GrupoProdutoRoot.get("descricao")), 
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(GrupoProdutoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(GrupoProdutoRoot.get("descricao")));
		
		TypedQuery<GrupoProduto> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<GrupoProduto> porDescricao(String descricao) {
		return this.manager.createQuery("from GrupoProduto where upper(descricao) like :descricao", GrupoProduto.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
	
}
	
