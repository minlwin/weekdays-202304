package com.jdc.goldern.members.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.goldern.members.model.entity.RewardTransaction;

public interface RewardTransactionRepo extends JpaRepositoryImplementation<RewardTransaction, Long>{

}