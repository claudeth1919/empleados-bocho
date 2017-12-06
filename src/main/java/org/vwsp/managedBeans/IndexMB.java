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

import org.vwsp.entities.Empleado;
import org.vwsp.entities.TipoPersonal;
import org.vwsp.managedBeans.utils.EmpleadoAbstract;
import org.vwsp.util.EmpleadoUtils;


@ManagedBean
@ViewScoped
public class IndexMB extends EmpleadoAbstract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@PostConstruct
	public void init() {
		tiposDePersonal = getTiposDePersonal();
	}
	
	public void registrarEmpleado() {		
		if(!isEmpleadoValid()) return ; //Detine el método si no está bien llenado el formulario
		Empleado empleado= this.crearEmpleado();
		empleadoService.saveOrUpdate(empleado);
		this.limpiarFormulario();
		showMessage(INFO, "", "Empleado registrado correctamente");
		EmpleadoUtils.updateViewElement("formgral");
	}
	
	private void limpiarFormulario() {
		direccion ="";
		nombre = "";
		fechaNacimiento =null;
		telefonoCasa = "";
		telefonoOficina = "";
		telefonoMovil = "";
	}
	
	private Empleado crearEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setDireccion(direccion);
		empleado.setNombre(nombre);
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setGenero(genero);
		empleado.setTelefonoCasa(telefonoCasa);
		empleado.setTelefonoOficina(telefonoOficina);
		empleado.setTelefonoMovil(telefonoMovil);
		empleado.setTipoPersonal(this.findTipoPersonal(this.idTipoPersonalSelected));
		return empleado;
	}
	
	
}


