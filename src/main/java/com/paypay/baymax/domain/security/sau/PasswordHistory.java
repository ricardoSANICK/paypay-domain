package com.paypay.baymax.domain.security.sau;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.envers.Audited;

import com.paypay.baymax.domain.security.Users;

import java.util.Date;

@Entity
@Table(name = "PasswordHistory")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
public class PasswordHistory {

	private long id;
	private String password;
	private Users username;
	private Date recordDate;

	public PasswordHistory() {
		super();
	}

	public PasswordHistory(long id) {
		this.id = id;
	}

	public PasswordHistory(long id, String password, Users username, Date recordDate) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.recordDate = recordDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "password", nullable = false, length = 300)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_username", nullable = true, referencedColumnName = "username")
	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}

	@Column(name = "recordDate", nullable = false, updatable = false, columnDefinition = "datetime")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
}
