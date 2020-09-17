package com.paypay.baymax.domain.general;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.envers.Audited;

@MappedSuperclass
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
public class TAudit implements java.io.Serializable {

	private static final long serialVersionUID = -2843406221087662797L;

	private Date recordDate;
	private Date updateDate;
	private String recordUsername;
	private String updateUsername;

	@Column(name = "recordDate", nullable = true, updatable = false, columnDefinition = "datetime")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	@Column(name = "updateDate", columnDefinition = "datetime")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "recordUsername", nullable = true, length = 50, updatable = false)
	public String getRecordUsername() {
		return recordUsername;
	}

	public void setRecordUsername(String recordUsername) {
		this.recordUsername = recordUsername;
	}

	@Column(name = "updateUsername", length = 50)
	public String getUpdateUsername() {
		return updateUsername;
	}

	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}

}
