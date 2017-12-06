package org.vwsp.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vwsp.dao.GenericDAO;

/**
 * Descripci�n:
 * @version 1.0 17/05/2017
 * @author dzm7kex
 */
@Repository
public class GenericDAOImpl<Entity> implements GenericDAO<Entity> {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session currentSession() {
		return getSessionFactory().getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see org.vwsp.dao.GenericDAO#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Entity T) {
		try {
			System.out.print("-  insert  -");
			currentSession().saveOrUpdate(T);
			System.out.print("-  insert se iso -");
		} catch (Exception e) {
			System.out.print("-  no insert  -");
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.vwsp.dao.GenericDAO#saveOrUpdateAll(java.util.List)
	 */
	@Override
	public void saveOrUpdateAll(List<Entity> T) {
		for(Entity e : T) {
			saveOrUpdate(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.vwsp.dao.GenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Entity T) {
		try {
			currentSession().delete(T);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.vwsp.dao.GenericDAO#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<Entity> T) {
		for(Entity e : T) {
			delete(e);
		}
	}

}
