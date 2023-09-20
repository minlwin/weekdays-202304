package com.jdc.goldern.members.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;

@Entity
@EntityListeners(value = AuditingEntityListener.class)
public class Admin extends Account{

}
