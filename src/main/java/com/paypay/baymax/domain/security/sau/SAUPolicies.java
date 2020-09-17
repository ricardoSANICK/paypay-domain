package com.paypay.baymax.domain.security.sau;

import java.util.Date;
import javax.persistence.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.envers.Audited;

import com.paypay.baymax.domain.general.TAudit;

@MappedSuperclass
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
public class SAUPolicies extends TAudit implements java.io.Serializable {

	private static final long serialVersionUID = -5449567726569733107L;
	private Integer failedAttemps;
	private Date lastPasswordChange;
	private Date lastPasswordReset;
	private Date lastAccess;
	private Date lockDate;
	private String lastToken;
	private Date expirationDateToken;
	private String resetRequestPassword;

	public SAUPolicies() {
		super();
	}

	/**
	 *
	 * @param failedAttemps
	 * @param lastPasswordChange
	 * @param lastPasswordReset
	 * @param lastAccess
	 * @param lockDate
	 * @param lastToken
	 * @param expirationDateToken
	 * @param resetRequestPassword
	 */
	public SAUPolicies(Integer failedAttemps, Date lastPasswordChange, Date lastPasswordReset, Date lastAccess,
			Date lockDate, String lastToken, Date expirationDateToken, String resetRequestPassword) {
		super();
		this.failedAttemps = failedAttemps;
		this.lastPasswordChange = lastPasswordChange;
		this.lastPasswordReset = lastPasswordReset;
		this.lastAccess = lastAccess;
		this.lockDate = lockDate;
		this.lastToken = lastToken;
		this.expirationDateToken = expirationDateToken;
		this.resetRequestPassword = resetRequestPassword;
	}

	@Column(name = "failedAttemps")
	public Integer getFailedAttemps() {
		return failedAttemps;
	}

	public void setFailedAttemps(Integer failedAttemps) {
		this.failedAttemps = failedAttemps;
	}

	@Column(name = "lastPasswordChange", columnDefinition = "datetime")
	public Date getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(Date lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	@Column(name = "lastPasswordReset", columnDefinition = "datetime")
	public Date getLastPasswordReset() {
		return lastPasswordReset;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	@Column(name = "lastAccess", columnDefinition = "datetime")
	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	@Column(name = "lockDate", columnDefinition = "datetime")
	public Date getLockDate() {
		return lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	@Column(name = "lastToken", columnDefinition = "text")
	public String getLastToken() {
		return lastToken;
	}

	public void setLastToken(String lastToken) {
		this.lastToken = lastToken;
	}

	@Column(name = "expirationDateToken", columnDefinition = "datetime")
	public Date getExpirationDateToken() {
		return expirationDateToken;
	}

	public void setExpirationDateToken(Date expirationDateToken) {
		this.expirationDateToken = expirationDateToken;
	}

	@Column(name = "resetRequestPassword", length = 300)
	public String getResetRequestPassword() {
		return resetRequestPassword;
	}

	public void setResetRequestPassword(String resetRequestPassword) {
		this.resetRequestPassword = resetRequestPassword;
	}
}
