package pelis.services;

/**
 * @author Isma
 *
 */
import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pelis.dao.AbstractDao;

@Service
public class BaseServiceImpl<P extends Serializable, E> implements BaseService<P, E> {

	private AbstractDao<P, E> genericDao;

	public BaseServiceImpl(AbstractDao<P, E> genericDao) {
		this.genericDao = genericDao;
	}

	public BaseServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		genericDao.saveOrUpdate(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll() {
		return genericDao.getAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity) {
		genericDao.update(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E getByKey(P key) {
		return genericDao.getByKey(key);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer save(E entity) {
		return genericDao.save(entity);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(E entity) {
		genericDao.delete(entity);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> find(List<Criterion> filtros, List<Order> orden) {
		return genericDao.find(filtros, orden);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> find(List<Criterion> filtros, List<Order> orden, int primero, int maximo) {
		return genericDao.find(filtros, orden, primero, maximo);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(List<Criterion> filtros) {
		return genericDao.count(filtros);

	}

}
