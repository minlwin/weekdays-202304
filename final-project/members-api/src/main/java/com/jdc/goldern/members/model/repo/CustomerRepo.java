package com.jdc.goldern.members.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.goldern.members.model.entity.Customer;

public interface CustomerRepo extends JpaRepositoryImplementation<Customer, Long>{

}