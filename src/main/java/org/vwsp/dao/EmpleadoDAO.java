/**
 * 
 */
package org.vwsp.dao;

import java.util.List;


import org.vwsp.entities.Empleado;

public interface EmpleadoDAO extends GenericDAO<Empleado> {
	
	Empleado findEmpleado(int idEmpleado);
	
	void updateEstadoInactivo(int idEmpleado);
	
	List<Empleado> findEmpleados();
	
}
