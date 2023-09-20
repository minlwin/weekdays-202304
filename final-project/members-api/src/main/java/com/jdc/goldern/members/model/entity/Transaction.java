package com.jdc.goldern.members.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.consts.TransactionType;
import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "transaction_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "transaction_seq")
	private long id;

	@ManyToOne(optional = false)
	private Account account;

	@Column(nullable = false)
	private TransactionType type;

	@Column(nullable = false)
	private LocalDateTime issueAt;

	@Column(nullable = false)
	private BigDecimal lastAmount;

	@Column(nullable = false)
	private BigDecimal transactionAmount;

}