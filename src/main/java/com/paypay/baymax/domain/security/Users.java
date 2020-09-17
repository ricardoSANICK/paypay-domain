package com.paypay.baymax.domain.security;

import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.paypay.baymax.domain.security.sau.SAUPolicies;

import java.util.Date;


@Entity
@Table(name = "users")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
public class Users extends SAUPolicies implements java.io.Serializable {

	private static final long serialVersionUID = -2843406221087662797L;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String avatar;
	private String email;
	private String telephone;
	private String cellphone;
	private String groups;
	private boolean locked;
	private boolean enabled;

	public Users() {
	}

	/**
	 * 
	 * @param username Identificador del usuario
	 * @param password Contrasena del usuario
	 * @param enabled  Estatus del usuario Activo o Inactivo (True o False)
	 */
	public Users(String username, String password, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * @param id
	 * @param failedAttemps
	 * @param lastPasswordChange
	 * @param lastPasswordReset
	 * @param lastAccess
	 * @param lockDate
	 * @param lastToken
	 * @param expirationDateToken
	 * @param resetRequestPassword
	 */
	public Users(long id, Integer failedAttemps, Date lastPasswordChange, Date lastPasswordReset, Date lastAccess,
			Date lockDate, String lastToken, Date expirationDateToken, String resetRequestPassword, String username,
			String password, String firstName, String lastName, String avatar, String email, String telephone,
			String cellphone, String groups, boolean locked, boolean enabled) {
		super(failedAttemps, lastPasswordChange, lastPasswordReset, lastAccess, lockDate, lastToken,
				expirationDateToken, resetRequestPassword);
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
		this.email = email;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.groups = groups;
		this.locked = locked;
		this.enabled = enabled;
	}

// Beans ..........................................

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@NotAudited
	@Column(name = "password", nullable = false, length = 300)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstName", length = 150)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", length = 150)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "avatar", columnDefinition = "text")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "email", length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telephone", length = 200)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "cellphone", length = 200)
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Column(name = "groups", length = 2000)
	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	@Column(name = "locked")
	public boolean getLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Column(name = "enabled")
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
