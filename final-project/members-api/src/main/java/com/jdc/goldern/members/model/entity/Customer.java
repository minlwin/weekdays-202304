package com.jdc.goldern.members.model.entity;

import java.time.LocalDate;

import com.jdc.goldern.members.model.entity.consts.Gender;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends Account {

	private Gender gender;

	private LocalDate dateOfBirth;

	private Address address;

	private Account referer;

}