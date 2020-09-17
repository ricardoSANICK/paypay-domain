package com.paypay.baymax.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.envers.Audited;

import com.paypay.baymax.domain.general.TAudit;

@Entity
@Table(name = "group_members", uniqueConstraints = {
		@UniqueConstraint(name = "UK_Username_GroupID_GM", columnNames = { "username", "group_id" }) })
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
public class Group_members extends TAudit implements java.io.Serializable {

	private static final long serialVersionUID = 949215488920605351L;
	private Integer id;
	private Groups group_id;
	private String username;

	public Group_members() {
	}

	/**
	 *
	 * @param id
	 */
	public Group_members(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @param id
	 * @param groups
	 * @param username
	 */
	public Group_members(int id, Groups groups, String username) {
		this.id = id;
		this.group_id = groups;
		this.username = username;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	public Groups getGroup_id() {
		return this.group_id;
	}

	public void setGroup_id(Groups group_id) {
		this.group_id = group_id;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
