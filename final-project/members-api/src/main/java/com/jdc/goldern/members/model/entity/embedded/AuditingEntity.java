package com.jdc.goldern.members.model.entity.embedded;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AuditingEntity {

	private AuditInfo audit = new AuditInfo();
}
