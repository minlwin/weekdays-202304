package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@EntityListeners(value = AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "gold_vault_seq")
public class GoldVault extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "gold_vault_seq")
	private long id;

	@OneToOne(optional = false)
	private Account account;

	@Column(nullable = false)
	private BigDecimal currentAmount;


}