package com.paypay.baymax.domain.binnacle;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Table(name = "TBitacora")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class TBitacora {

	private int bitacora_id;
	private Date fecha;
	private Integer hora;
	private String usuario_username;
	private String modulo;
	private String url;
	private String requestAddress;
	private String accion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bitacora_id", unique = true, nullable = false)
	public int getBitacora_id() {
		return bitacora_id;
	}

	public void setBitacora_id(int id) {
		bitacora_id = id;
	}

	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "hora")
	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	@Column(name = "usuario_username")
	public String getUsuario_username() {
		return usuario_username;
	}

	public void setUsuario_username(String usuario_username) {
		this.usuario_username = usuario_username;
	}

	@Column(name = "modulo")
	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "requestAddress")
	public String getRequestAddress() {
		return requestAddress;
	}

	public void setRequestAddress(String requestAddress) {
		this.requestAddress = requestAddress;
	}

	@Column(name = "accion")
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

}