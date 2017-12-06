/**
 * 
 */
package org.vwsp.managedBeans.utils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.vwsp.entities.TipoPersonal;
import org.vwsp.service.EmpleadoService;

/**
 * 
 * Clase abstracta que define el comportamiento de los managed beans 
 * 
 * @author Ivan Alejandro
 *
 */
public abstract class ManagedBeanAbstract {
	
	protected final Severity INFO = FacesMessage.SEVERITY_INFO;
	protected final Severity ERROR = FacesMessage.SEVERITY_ERROR;
	protected final Severity WARN = FacesMessage.SEVERITY_WARN;
	
	
	protected List<FacesMessage> mensajes;
	
	protected String serviceName;
	
	
	protected List<TipoPersonal> tiposDePersonal;
	
	@ManagedProperty(value = "#{empleadoService}")
	protected EmpleadoService empleadoService;
	
	protected abstract void init();
	
	/**
	 * 
	 * Metodo que agrega la lista de mensajes al contexto
	 * 
	 */
	protected void addMessagesToContext(){
		addMessagesToContext(null);
	}
	
	
	
	protected TipoPersonal findTipoPersonal(Integer idTipoPersonal) {
		for (TipoPersonal tipo : tiposDePersonal) {
			if(idTipoPersonal==tipo.getIdTipoPersonal()) {
				return tipo;
			}
		}
		return  null;
	}
	
	
	
	/*
	 * Muestra un sólo mensaje
	 */
	protected void showMessage(Severity severity, String subtitulo, String mensaje){
		addMessage(severity, subtitulo, mensaje);
		addMessagesToContext();
		clearMessages();
	}
	
	/**
	 * Metodo que agrega la lista de mensajes al contexto.
	 *
	 * @param toComponent the to component
	 */
	protected void addMessagesToContext(String toComponent){
		FacesContext context = FacesContext.getCurrentInstance();
		
		for(FacesMessage mensaje : mensajes){
			context.addMessage(toComponent, mensaje);
		}
	}
	
	/**
	 * 
	 * Metodo que agrega un mensaje a la lista de mensajes
	 * 
	 * @param severity
	 * @param msgSummary
	 * @param msgDetail
	 */
	protected void addMessage(Severity severity, String msgSummary, String msgDetail){
		if(mensajes == null){
			mensajes = new ArrayList<>();
		}
		
		mensajes.add(new FacesMessage(severity, msgSummary, msgDetail));
	}

	/**
	 * 
	 * Metodo que limpia la lista mensajes
	 * 
	 */
	protected void clearMessages(){
		mensajes = new ArrayList<>();
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	public void setTiposDePersonal(List<TipoPersonal> tiposDePersonal) {
		this.tiposDePersonal = tiposDePersonal;
	}
	
	public List<TipoPersonal> getTiposDePersonal(){
		return empleadoService.getTiposDePersonal();
	}
	
}
