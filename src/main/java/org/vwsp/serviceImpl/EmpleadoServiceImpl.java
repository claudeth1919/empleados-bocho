package org.vwsp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.vwsp.dao.EmpleadoDAO;
import org.vwsp.dao.TipoPersonalDAO;
import org.vwsp.entities.TipoPersonal;
import org.vwsp.entities.Empleado;
import org.vwsp.service.EmpleadoService;

/**
 * Descripci�n:
 * @version 1.0 15/05/2017
 * @author fox171x
 */
@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	private TipoPersonalDAO tipoEmpleadoDAO;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<Empleado> getEmpleados() {
		return empleadoDAO.findEmpleados();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Empleado getEmpleado(int idEncuestado) {
		return empleadoDAO.findEmpleado(idEncuestado);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(Empleado empleado) {
		empleadoDAO.saveOrUpdate(empleado);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<TipoPersonal> getTiposDePersonal() {
		return tipoEmpleadoDAO.findTiposDePersonal();
	}


}
