/**
 * 
 */
package org.vwsp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.vwsp.dao.TipoPersonalDAO;
import org.vwsp.entities.TipoPersonal;

@Repository
public class TipoPersonalDAOImpl extends GenericDAOImpl<TipoPersonal>  implements TipoPersonalDAO {

	@Override
	public List<TipoPersonal> findTiposDePersonal() {
		StringBuilder query = new StringBuilder("SELECT t FROM TipoPersonal t");

		Query queryObj = currentSession().createQuery(query.toString());

		@SuppressWarnings("unchecked")
		List<TipoPersonal> results = queryObj.getResultList();

		return results;
	}
	
}
