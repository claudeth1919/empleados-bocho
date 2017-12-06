/**
 * 
 */
package org.vwsp.dao;

import java.util.List;

/**
 * Descripción:
 * @version 1.0 17/05/2017
 * @author dzm7kex
 */
public interface GenericDAO<Entity> {

	void saveOrUpdate(Entity T);
	
	void saveOrUpdateAll(List<Entity> T);
	
	void delete(Entity T);
	
	void deleteAll(List<Entity> T);
	
}
