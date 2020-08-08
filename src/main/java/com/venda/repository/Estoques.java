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
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
//import javax.persistence.criteria.Fetch;
//import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.venda.model.Estoque;
import com.venda.repository.filter.EstoqueFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Estoques implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Estoque porId(Long id) {
		return this.manager.find(Estoque.class, id);
	}
	
	
	public List<Estoque> lista_estoques() {
		
		return this.manager.createQuery("from Estoque", Estoque.class)
				.getResultList();
	}

	public Estoque guardar(Estoque estoque) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		estoque = manager.merge(estoque);
		
		trx.commit();
		
		return estoque;
	}


	@Transactional
	public void remover(Estoque estoque) throws NegocioException {
		try {
			estoque = porId(estoque.getId());
			manager.remove(estoque);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Estoque não pode ser excluído.");
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

	
	
	public List<Estoque> filtrados(EstoqueFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Estoque> criteriaQuery = builder.createQuery(Estoque.class);
		
		
		
		//List<Predicate> predicates = criarPredicatesParaFiltro(filtro, pedidoRoot, clienteJoin, vendedorJoin);
		List<Predicate> predicates = new ArrayList<>();
		
	//	From<?, ?> orderByFromEntity = null;
		
		Root<Estoque> estoqueRoot = criteriaQuery.from(Estoque.class);
		
		From<?, ?> clienteJoin = (From<?, ?>) estoqueRoot.fetch("produto", JoinType.INNER);
		
		
		if (StringUtils.isNotBlank(filtro.getDescricaoProduto())) {
			predicates.add(builder.like(clienteJoin.get("descricao"), "%" + filtro.getDescricaoProduto() + "%"));
		}
		
		if (filtro.getData_compra() != null) {
			predicates.add(builder.equal(estoqueRoot.get("data_compra"), filtro.getData_compra()));
		}
		
		criteriaQuery.select(estoqueRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
	//	criteriaQuery.orderBy(builder.asc(estoqueRoot.get("descricao")));
		
		TypedQuery<Estoque> query = manager.createQuery(criteriaQuery);
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
	
