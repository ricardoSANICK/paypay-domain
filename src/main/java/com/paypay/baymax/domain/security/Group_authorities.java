package com.paypay.baymax.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.paypay.baymax.domain.general.TAudit;

@Entity
@Table(name = "group_authorities", uniqueConstraints = {
		@UniqueConstraint(name = "UK_Authority_ID_GA", columnNames = { "authority", "group_id" }) })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
public class Group_authorities extends TAudit implements java.io.Serializable {
	
	private static final long serialVersionUID = -3168079861790990490L;
	private Integer id;
	private Groups group_id;
	private String authority;

	public Group_authorities() {
	}

	public Group_authorities(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @param id
	 * @param group_id
	 * @param authority
	 */
	public Group_authorities(Integer id, Groups group_id, String authority) {
		this.id = id;
		this.group_id = group_id;
		this.authority = authority;
	}

	// Beans ...........................................

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotAudited
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	public Groups getGroup_id() {
		return this.group_id;
	}

	public void setGroup_id(Groups group_id) {
		this.group_id = group_id;
	}

	@Column(name = "authority", nullable = false, length = 50)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
