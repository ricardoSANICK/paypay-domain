package com.paypay.baymax.domain.mail;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name = "TCorreo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class TCorreo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4509588507312177076L;

	// Columnas ........................................

	private int id;
	private String origen;
	private Date fechaEnvio;
	private String tipo;
	private String de;
	private String para;
	private String cc;
	private String cco;
	private String asunto;
	private String cuerpo;
	private String adjunto;
	private String estatus;
	private Date fechaEstatus;
	private int horaEstatus;
	private String error;
	private int nIntentosError;

	private Date fechaalta;

	// Constructores ...................................

	public TCorreo() {
		super();
	}

	/**
	 * 
	 * @param id
	 */
	public TCorreo(int id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 * @param id
	 * @param origen
	 * @param fechaEnvio
	 * @param tipo
	 * @param de
	 * @param para
	 * @param cc
	 * @param cco
	 * @param asunto
	 * @param cuerpo
	 * @param adjunto
	 * @param nombreAdjunto
	 * @param adjuntoBlob
	 * @param nombreAdjuntoBlob
	 * @param estatus
	 * @param fechaEstatus
	 * @param horaEstatus
	 * @param error
	 * @param nIntentosError
	 * @param fechaalta
	 */
	public TCorreo(int id, String origen, Date fechaEnvio, String tipo, String de, String para, String cc, String cco,
			String asunto, String cuerpo, String adjunto, String estatus, Date fechaEstatus, int horaEstatus,
			String error, int nIntentosError, Date fechaalta) {
		super();
		this.id = id;
		this.origen = origen;
		this.fechaEnvio = fechaEnvio;
		this.tipo = tipo;
		this.de = de;
		this.para = para;
		this.cc = cc;
		this.cco = cco;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.adjunto = adjunto;
		this.estatus = estatus;
		this.fechaEstatus = fechaEstatus;
		this.horaEstatus = horaEstatus;
		this.error = error;
		this.nIntentosError = nIntentosError;
		this.fechaalta = fechaalta;
	}

	// Beans ...........................................

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "origen", length = 50)
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Column(name = "fechaenvio", columnDefinition = "datetime")
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	@Column(name = "tipo", length = 70)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "de", length = 50)
	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	@Column(name = "para", nullable = false, length = 600)
	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	@Column(name = "cc", length = 600)
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Column(name = "cco", length = 600)
	public String getCco() {
		return cco;
	}

	public void setCco(String cco) {
		this.cco = cco;
	}

	@Column(name = "asunto", nullable = false, length = 100)
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	@Column(name = "cuerpo", nullable = false, columnDefinition = "text")
	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Column(name = "adjunto", columnDefinition = "text")
	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}

	@Column(name = "estatus", nullable = false, length = 50)
	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Column(name = "fechaestatus", columnDefinition = "datetime")
	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	@Column(name = "horaestatus", columnDefinition = "int default 0", nullable = false)
	public int getHoraEstatus() {
		return horaEstatus;
	}

	public void setHoraEstatus(int horaEstatus) {
		this.horaEstatus = horaEstatus;
	}

	@Column(name = "error", length = 255)
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Column(name = "nIntentosError", columnDefinition = "int default 0", nullable = false)
	public int getnIntentosError() {
		return nIntentosError;
	}

	public void setnIntentosError(int nIntentosError) {
		this.nIntentosError = nIntentosError;
	}

	@Column(name = "fechaalta", nullable = false, updatable = false, columnDefinition = "datetime")
	public Date getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

}
