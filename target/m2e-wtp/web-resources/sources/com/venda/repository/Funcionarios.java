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

import com.venda.model.Funcionario;
import com.venda.repository.filter.FuncionarioFilter;
import com.venda.service.NegocioException;
import com.venda.util.jpa.Transactional;


public class Funcionarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Funcionario porId(Long id) {
		return this.manager.find(Funcionario.class, id);
	}
	
	
	public List<Funcionario> funcionarios() {
		
		return this.manager.createQuery("from Funcionario", Funcionario.class)
				.getResultList();
	}

	public Funcionario guardar(Funcionario funcionario) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		funcionario = manager.merge(funcionario);
		
		trx.commit();
		
		return funcionario;
	}


	@Transactional
	public void remover(Funcionario funcionario) throws NegocioException {
		try {
			funcionario = porId(funcionario.getId());
			manager.remove(funcionario);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Funcionario não pode ser excluído.");
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

	
	
	public List<Funcionario> filtrados(FuncionarioFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteriaQuery = builder.createQuery(Funcionario.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Funcionario> lojaRoot = criteriaQuery.from(Funcionario.class);
		
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(lojaRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(lojaRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(lojaRoot.get("nome")));
		
		TypedQuery<Funcionario> query = manager.createQuery(criteriaQuery);
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
	
