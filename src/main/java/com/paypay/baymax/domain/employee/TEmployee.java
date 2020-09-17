package com.paypay.baymax.domain.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;

import com.paypay.baymax.domain.general.TAudit;

@Entity
@Table(name = "TEmployee")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class TEmployee extends TAudit implements java.io.Serializable {
	
	private static final long serialVersionUID = -6449038185718511016L;
	private Long id;
	private String name;
	private boolean status;
	
	public TEmployee(Long id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public TEmployee() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", columnDefinition = "bit default 1")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
