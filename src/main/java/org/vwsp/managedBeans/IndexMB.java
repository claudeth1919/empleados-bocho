/**
 * 
 */
package org.vwsp.managedBeans;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.vwsp.entities.TipoPersonal;
import org.vwsp.service.EmpleadoService;


@ManagedBean
@ViewScoped
public class IndexMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String nombre;
	protected Date fechaNacimiento;
	protected String direccion;
	protected Character genero;
	protected String fotografia;
	
	protected Integer idTipoPersonalSelected;
	
	protected final Date HOY = new Date(); 
	
	protected List<TipoPersonal> tiposDePersonal;
	
	@ManagedProperty(value = "#{empleadoService}")
	private EmpleadoService empleadoService;
	
	
	@PostConstruct
	public void init() {
		tiposDePersonal = empleadoService.getTiposDePersonal();
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

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public List<TipoPersonal> getTiposDePersonal() {
		return tiposDePersonal;
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
	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}
	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	
	
	
}


