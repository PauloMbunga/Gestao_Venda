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

import com.venda.model.TipoCliente;
import com.venda.repository.filter.TipoClienteFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class TipoClientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public TipoCliente porId(Long id) {
		return this.manager.find(TipoCliente.class, id);
	}
	
	
	public List<TipoCliente> lista_tipoClientes() {
		
		return this.manager.createQuery("from TipoCliente", TipoCliente.class)
				.getResultList();
	}

	public TipoCliente guardar(TipoCliente tipoCliente) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		tipoCliente = manager.merge(tipoCliente);
		
		trx.commit();
		
		return tipoCliente;
	}


	@Transactional
	public void remover(TipoCliente tipoCliente) throws NegocioException {
		try {
			tipoCliente = porId(tipoCliente.getId());
			manager.remove(tipoCliente);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Forma de Pagamento não pode ser excluído.");
		}
	}

	
	
	public List<TipoCliente> filtrados(TipoClienteFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TipoCliente> criteriaQuery = builder.createQuery(TipoCliente.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<TipoCliente> TipoClienteRoot = criteriaQuery.from(TipoCliente.class);
		
		
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			predicates.add(builder.like(builder.lower(TipoClienteRoot.get("descricao")), 
					"%" + filtro.getDescricao().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(TipoClienteRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(TipoClienteRoot.get("descricao")));
		
		TypedQuery<TipoCliente> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	public List<TipoCliente> porDescricao(String descricao) {
		return this.manager.createQuery("from TipoCliente where upper(descricao) like :descricao", TipoCliente.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
	}
	
}
	
