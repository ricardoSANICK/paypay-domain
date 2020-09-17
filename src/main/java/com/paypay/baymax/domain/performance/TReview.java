package com.paypay.baymax.domain.performance;

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
@Table(name = "TReview")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class TReview extends TAudit implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private String assigners;
	private boolean status;

	public TReview(Long id, String description, String assigners, boolean status) {
		super();
		this.id = id;
		this.description = description;
		this.assigners = assigners;
		this.status = status;
	}

	public TReview() {
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
	
	@Column(name = "description", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "assigners", length = 100)
	public String getAssigners() {
		return assigners;
	}

	public void setAssigners(String assigners) {
		this.assigners = assigners;
	}
	
	@Column(name = "status", columnDefinition = "bit default 1")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
