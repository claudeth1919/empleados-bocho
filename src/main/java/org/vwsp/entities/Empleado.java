package org.vwsp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;
	
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTipoPersonal")
	private TipoPersonal tipoPersonal;
	
	private Date fechaNacimiento;
	
	private String direccion;
	
	private String telefonoCasa;
	
	private String telefonoOficina;
	
	private String telefonoMovil;
	
	private Character genero;
	
	private String urlFotografia;
	
	@Column(name = "activo", insertable = false)
	private Boolean activo;
	
	
	
	public TipoPersonal getTipoPersonal() {
		return tipoPersonal;
	}
	public void setTipoPersonal(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	public TipoPersonal getEncEncuesta() {
		return tipoPersonal;
	}
	public void setEncEncuesta(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	
	public String getUrlFotografia() {
		return urlFotografia;
	}
	public void setUrlFotografia(String urlFotografia) {
		this.urlFotografia = urlFotografia;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public String getTelefonoCasa() {
		return telefonoCasa;
	}
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}
	public String getTelefonoOficina() {
		return telefonoOficina;
	}
	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	@Override
	public String toString() {
		return "ID: "+this.idEmpleado+"\ntelefono Movil: "+this.telefonoMovil+"\n Género"+ this.genero;
	}

}
