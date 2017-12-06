/**
 * 
 */
package org.vwsp.dao;

import java.util.Date;
import java.util.List;

import org.vwsp.entities.Empleado;
import org.vwsp.entities.TipoPersonal;


public interface TipoPersonalDAO extends GenericDAO<TipoPersonal> {	
	List<TipoPersonal> findTiposDePersonal();
}
