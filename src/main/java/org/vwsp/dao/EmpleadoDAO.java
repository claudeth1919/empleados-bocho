/**
 * 
 */
package org.vwsp.dao;

import java.util.List;


import org.vwsp.entities.Empleado;

public interface EmpleadoDAO extends GenericDAO<Empleado> {
	
	Empleado findEmpleado(int idEmpleado);
	
	List<Empleado> findEmpleados();
	
}
