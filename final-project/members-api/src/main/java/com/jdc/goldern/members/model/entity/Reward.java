package com.jdc.goldern.members.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.goldern.members.model.entity.embedded.AuditingEntity;

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
@Entity
@EntityListeners(value = AuditingEntityListener.class)
@SequenceGenerator(name = "reward_seq", allocationSize = 1)
public class Reward extends AuditingEntity{

	@Id
	@GeneratedValue(generator = "reward_seq")
	private long id;

	@OneToOne(optional = false)
	private Sale sale;

	@OneToOne(mappedBy = "reward")
	private RewardForCustomer customerReward;

	@OneToOne(mappedBy = "reward")
	private RewardForReferer refererReward;

}