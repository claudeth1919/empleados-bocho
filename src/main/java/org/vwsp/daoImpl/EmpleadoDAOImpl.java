/**
 * 
 */
package org.vwsp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.vwsp.dao.EmpleadoDAO;
import org.vwsp.entities.Empleado;

@Repository
public class EmpleadoDAOImpl extends GenericDAOImpl<Empleado>  implements EmpleadoDAO {

	@Override
	public Empleado findEmpleado(int idEmpleado) {
		StringBuilder query = new StringBuilder("SELECT e FROM Empleado e ");
		query.append(" WHERE e.idEmpleado = :idEmpleado");

		Query queryObj = currentSession().createQuery(query.toString())
		.setParameter("idEmpleado", idEmpleado);

		@SuppressWarnings("unchecked")
		List<Empleado> results = queryObj.getResultList();

		Empleado result = null;
		if(results != null && !results.isEmpty()){
			result = results.get(0);
		}

		return result;
	}

	@Override
	public List<Empleado> findEmpleados() {
		StringBuilder query = new StringBuilder("SELECT e FROM Empleado e WHERE activo=1 ");

		Query queryObj = currentSession().createQuery(query.toString());

		@SuppressWarnings("unchecked")
		List<Empleado> results = queryObj.getResultList();

		return results;
	}

	@Override
	public void updateEstadoInactivo(int idEmpleado) {
		StringBuilder query = new StringBuilder("UPDATE Empleado e SET e.activo=0 ");
		query.append(" WHERE e.idEmpleado = :idEmpleado");

		currentSession().createQuery(query.toString()).setParameter("idEmpleado", idEmpleado).executeUpdate();
		
	}
	
}
