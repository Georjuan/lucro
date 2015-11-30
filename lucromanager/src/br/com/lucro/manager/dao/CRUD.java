package br.com.lucro.manager.dao;

import java.util.List;

/**
 * CRUD model interface
 * @author Georjuan Taylor
 */
public interface CRUD<T> {
	
	/** Create new {@code <T object>} in DB.
	 * @return Copy of the created object
	 **/
	T create(T object) throws Exception;
	
	/** Retrieve {@code <T object>} from DB by {@code <T object>} id key. 
	 * @return The retrieved object
	 * */
	T select(T object) throws Exception;
	
	/** Update {@code <T object>} in DB by {@code <T object>} id key. 
	 * @return Copy of updated object
	 * */
	T update(T object) throws Exception;
	
	/** Delete {@code <T object>} from DB by {@code <T object>} id key. 
	 * @return Copy of the removed object
	 * */
	T delete(T object) throws Exception;
	
	/**
	 * @param object
	 * @return true if the object exists, false otherwise
	 */
	boolean exists(T object) throws Exception;
	
	/** Retrieve all {@code <T object>} from DB. 
	 * @return The retrieved list objects
	 * */
	List<T> selectAll() throws Exception;

}
