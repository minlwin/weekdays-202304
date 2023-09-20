package com.jdc.goldern.members.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.goldern.members.model.entity.Exchange;

public interface ExchangeRepo extends JpaRepositoryImplementation<Exchange, Long>{

}