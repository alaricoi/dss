/**
 * Implementación de servicio generico que nos porporciona los 
 * metodos de acceso y manipulacion de datos basicos
 * @author Isma
 *
 */
package pelis.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pelis.dao.AbstractDao;
/**
 * 
 * @author Isma
 *
 * @param <P>
 * @param <E>
 */
public class BaseServiceImpl<P extends Serializable, E> implements BaseService<P, E>{

	/**
	 * dao generico
	 */
	private AbstractDao<P, E> dao;

	/**
	 * @return the dao
	 */
	public AbstractDao<P, E> getDao(){
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(AbstractDao<P, E> dao){
		this.dao = dao;
	}

/**
 * constructour sin parametros
 */
	public BaseServiceImpl(){
	}
/**
 * insertar o editar
 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity){
		getDao().saveOrUpdate(entity);
	}
/**
 * todos los registros
 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll(){
		return getDao().getAll();
	}
/**
 * edita el registro pasado por parametro
 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity){
		getDao().update(entity);
	}
/**
 * extrae el objeto con la clave pasada por parametro
 * 
 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E getByKey(P key){
		return getDao().getByKey(key);
	}
/**
 * inserta un registro pasado por paramatro
 */
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer save(E entity){
		return getDao().save(entity);

	}
	/**
	 * borra un registro pasado por paramatro
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(E entity){
		getDao().delete(entity);

	}
	/**
	 * Busca los registros segun los criterios pasados por parametro
	 * filtros, los ordena segun la lista orden
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> find(List<Criterion> filtros, List<Order> orden) {
		return getDao().find(filtros, orden);

	}
	/**
	 * Busca los registros segun los criterios pasados por parametro
	 * filtros, los ordena segun la lista orden, busca a partir del
	 * parametro primero el nuemero de registros marcados por maximo
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> find(List<Criterion> filtros, List<Order> orden, int primero, int maximo) {
		return getDao().find(filtros, orden, primero, maximo);

	}
	
	/**
	 * nos porporciona el contador de  registros segun lo
 	* criterios pasados por parametro filtros
	 */

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(List<Criterion> filtros){
		return getDao().count(filtros);

	}

}
