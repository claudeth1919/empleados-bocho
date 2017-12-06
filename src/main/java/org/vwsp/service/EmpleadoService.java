/**
 * 
 */
package org.vwsp.service;



import java.util.List;

import org.vwsp.entities.Empleado;
import org.vwsp.entities.TipoPersonal;

public interface EmpleadoService {
	
	List<Empleado> getEmpleados();
	
	List<TipoPersonal> getTiposDePersonal();
	
	Empleado getEmpleado(int idEncuestado);
	
	void saveOrUpdate(Empleado empleado);

}
