package org.vwsp.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.vwsp.entities.Empleado;
import org.vwsp.managedBeans.utils.EmpleadoAbstract;
import org.vwsp.service.EmpleadoService;
import org.vwsp.util.EmpleadoUtils;

@ManagedBean
@ViewScoped
public class EditarEmpleadoMB extends EmpleadoAbstract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Empleado empleado;
	@ManagedProperty(value = "#{empleadoService}")
	protected EmpleadoService empleadoService;
	
	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
		tiposDePersonal = getTiposDePersonal();
		System.out.println("IDEMPLEADO: "+empleadoService.getEmpleado(idEmpleado).toString());
		this.empleado = empleadoService.getEmpleado(idEmpleado);;
		if(empleado!=null) {
			cargarEmpleado();
		}
	}
	
	private void cargarEmpleado() {
		this.nombre = empleado.getNombre();
		this.direccion = empleado.getDireccion();
		this.fechaNacimiento = empleado.getFechaNacimiento();
		this.telefonoCasa = empleado.getTelefonoCasa();
		this.telefonoMovil = empleado.getTelefonoMovil();
		this.telefonoOficina = empleado.getTelefonoOficina();
		this.idTipoPersonalSelected = empleado.getTipoPersonal().getIdTipoPersonal();
		this.genero = empleado.getGenero();
	}
	
	public void registrarEmpleado() {		
		if(!isEmpleadoValid()) return ; //Detine el método si no está bien llenado el formulario
		this.updateEmpleado();
		empleadoService.saveOrUpdate(this.empleado);
		showMessage(INFO, "", "Empleado editado correctamente");
	}
	
	private void updateEmpleado() {
		empleado.setDireccion(direccion);
		empleado.setNombre(nombre);
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setGenero(genero);
		empleado.setTelefonoCasa(telefonoCasa);
		empleado.setTelefonoOficina(telefonoOficina);
		empleado.setTelefonoMovil(telefonoMovil);
		empleado.setTipoPersonal(this.findTipoPersonal(this.idTipoPersonalSelected));
	}
	

	
	
	
}

