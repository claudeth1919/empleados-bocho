package org.vwsp.managedBeans;



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
import org.vwsp.service.EmpleadoService;
import org.vwsp.util.EmpleadoUtils;


@ManagedBean
@ViewScoped
public class ListaEmpleadosMB extends ManagedBeanAbstract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected List<Empleado> empleados;
	
	protected List<Empleado> filteredEmpleados;
	
	@PostConstruct
	public void init() {
		this.empleados = empleadoService.getEmpleados();
	}
	
	public void eliminarEmpleado(Integer index) {
		empleadoService.updateEstadoInactivo(empleados.get(index).getIdEmpleado());
		this.empleados =  empleadoService.getEmpleados();
		showMessage(INFO, "", "Se ha eliminado el usuario exitosamente");
	}

	public String formatoFecha(Date fecha) {
		return EmpleadoUtils.getDateFormatted(fecha);
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}


	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}


	public List<Empleado> getFilteredEmpleados() {
		return filteredEmpleados;
	}


	public void setFilteredEmpleados(List<Empleado> filteredEmpleados) {
		this.filteredEmpleados = filteredEmpleados;
	}
	
	
	
	
}

