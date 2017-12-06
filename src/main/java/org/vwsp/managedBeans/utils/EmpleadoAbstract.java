package org.vwsp.managedBeans.utils;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.vwsp.entities.Empleado;
import org.vwsp.entities.TipoPersonal;
import org.vwsp.managedBeans.utils.ManagedBeanAbstract;
import org.vwsp.util.EmpleadoUtils;


public abstract class EmpleadoAbstract extends ManagedBeanAbstract implements Serializable {
	
	protected String nombre;
	protected Date fechaNacimiento;
	protected String direccion;
	protected Character genero;
	protected String urlFotografia;
	protected String telefonoCasa;
	protected String telefonoMovil;
	protected String telefonoOficina;
	
	protected Integer idTipoPersonalSelected;
	
	protected final Date HOY = new Date(); 
	
	protected abstract void init();
	
	
	protected boolean isEmpleadoValid() {
		clearMessages();
		boolean valid = true;
		if(EmpleadoUtils.isEmptyString(this.nombre)) {
			addMessage(ERROR, "", "El campo nombre es requerido");
			valid=false;
		}
		if(EmpleadoUtils.isEmptyString(this.direccion)) {
			addMessage(ERROR, "", "La campo direccion es requerido");
			valid=false;
		}
		if(EmpleadoUtils.isEmptyString(this.telefonoMovil)) {
			addMessage(ERROR, "", "La campo teléfono movil es requerido");
			valid=false;
		}
		if(this.idTipoPersonalSelected==null) {
			addMessage(ERROR, "", "La campo tipoPersonal es requerido");
			valid=false;
		}
		if(this.fechaNacimiento==null) {
			addMessage(ERROR, "", "La campo Fecha de Nacimiento es requerido");
			valid=false;
		}
		if(this.genero==null) {
			addMessage(ERROR, "", "La campo género es requerido");
			valid=false;
		}
		addMessagesToContext();
		return valid;
	}
	
	
	
	
	/*
	 * 
	 * Geters y Seters
	 */
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


	public void setTiposDePersonal(List<TipoPersonal> tiposDePersonal) {
		this.tiposDePersonal = tiposDePersonal;
	}

	
	
	public Integer getIdTipoPersonalSelected() {
		return idTipoPersonalSelected;
	}

	public void setIdTipoPersonalSelected(Integer idTipoPersonalSelected) {
		this.idTipoPersonalSelected = idTipoPersonalSelected;
	}

	public Date getHOY() {
		return HOY;
	}
	
	public String getUrlFotografia() {
		return urlFotografia;
	}

	public void setUrlFotografia(String urlFotografia) {
		this.urlFotografia = urlFotografia;
	}

	public String getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getTelefonoOficina() {
		return telefonoOficina;
	}

	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	
	
	
	
}


