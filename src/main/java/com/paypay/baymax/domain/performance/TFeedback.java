package com.paypay.baymax.domain.performance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;

import com.paypay.baymax.domain.employee.TEmployee;
import com.paypay.baymax.domain.general.TAudit;

@Entity
@Table(name = "TFeedback")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class TFeedback extends TAudit implements java.io.Serializable {
	
	private static final long serialVersionUID = 3845637839394686741L;
	private Long id;
	private String description;
	private TEmployee assigner;
	private TEmployee assigned;
	private TReview review;
	private boolean status;

	public TFeedback(Long id, String description, TEmployee assigner, TEmployee assigned, TReview review, boolean status) {
		super();
		this.id = id;
		this.description = description;
		this.assigner = assigner;
		this.assigned = assigned;
		this.review = review;
		this.status = status;
	}

	public TFeedback() {
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
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_assigner", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_assigner"))
	public TEmployee getAssigner() {
		return assigner;
	}

	public void setAssigner(TEmployee assigner) {
		this.assigner = assigner;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_assigned", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_assigned"))
	public TEmployee getAssigned() {
		return assigned;
	}

	public void setAssigned(TEmployee assigned) {
		this.assigned = assigned;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_review", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_review"))
	public TReview getReview() {
		return review;
	}

	public void setReview(TReview review) {
		this.review = review;
	}

	@Column(name = "status", columnDefinition = "bit default 1")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
