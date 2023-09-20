package com.jdc.goldern.members.model;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
	implements BaseRepository<T, ID>{
	
	private EntityManager entityManager;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public <R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		var query = queryFunc.apply(entityManager.getCriteriaBuilder());
		return entityManager.createQuery(query).getResultList();
	}

}
