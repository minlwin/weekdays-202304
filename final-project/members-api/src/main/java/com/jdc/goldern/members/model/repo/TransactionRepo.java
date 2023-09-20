package com.jdc.goldern.members.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.goldern.members.model.entity.Transaction;

public interface TransactionRepo extends JpaRepositoryImplementation<Transaction, Long>{

}