package com.paypay.baymax.domain.mail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.envers.Audited;

import com.paypay.baymax.domain.general.TAudit;

@Entity
@Table(name = "TPlantillaCorreo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@Audited(targetAuditMode = org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED)
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class TPlantillaCorreo extends TAudit implements java.io.Serializable {

	private static final long serialVersionUID = -2621569040383886613L;

	// Columnas ........................................

	private String clave;
	private String descripcion;
	private String remitente;

	private String multiListPerfilesDestinatarios;

	private String destinatariosOpcionales;
	private String cc;
	private String cco;
	private String asunto;
	private String cuerpo;

	private boolean status;

	private Long version;

	// Constructores ...................................

	public TPlantillaCorreo() {
	}

	/**
	 * 
	 * @param clave       Identificador de la entidad
	 * @param descripcion Nombre de la plantilla
	 * @param status      Estatus de la plantilla Activa o Inactiva (True o False)
	 */
	public TPlantillaCorreo(String clave, String descripcion, boolean status) {
		this.clave = clave;
		this.descripcion = descripcion;
		this.status = status;
	}

	// Beans ...........................................

	@Id
	@Column(name = "clave", unique = true, nullable = false, length = 20)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "descripcion", length = 255)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "remitente", length = 255)
	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	@Column(name = "multiListPerfilesDestinatarios", length = 1000)
	public String getMultiListPerfilesDestinatarios() {
		return multiListPerfilesDestinatarios;
	}

	public void setMultiListPerfilesDestinatarios(String multiListPerfilesDestinatarios) {
		this.multiListPerfilesDestinatarios = multiListPerfilesDestinatarios;
	}

	@Column(name = "destinatariosOpcionales", length = 1000)
	public String getDestinatariosOpcionales() {
		return destinatariosOpcionales;
	}

	public void setDestinatariosOpcionales(String destinatariosOpcionales) {
		this.destinatariosOpcionales = destinatariosOpcionales;
	}

	@Column(name = "cc", length = 1000)
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Column(name = "cco", length = 1000)
	public String getCco() {
		return cco;
	}

	public void setCco(String cco) {
		this.cco = cco;
	}

	@Column(name = "asunto", length = 255)
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	@Column(name = "cuerpo", columnDefinition = "text")
	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Column(name = "status")
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Version
	@Column(name = "version", columnDefinition = "numeric(19,0) DEFAULT 0", nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
