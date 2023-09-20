package com.jdc.goldern.members.model;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepositoryImplementation<T, ID>{

	<R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> query); 
}
