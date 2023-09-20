package com.jdc.goldern.members.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.goldern.members.model.entity.GoldVault;

public interface GoldVaultRepo extends JpaRepositoryImplementation<GoldVault, Long>{

}