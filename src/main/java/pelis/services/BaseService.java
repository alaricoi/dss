package pelis.services;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public interface BaseService<P, E> {

	public void saveOrUpdate(E entity);

	public List<E> getAll();

	public E getByKey(P key);

	public Integer save(E entity);

	public void update(E entity);

	public void delete(E entity);

	public List<E> find(List<Criterion> filtros, List<Order> orden);

	public List<E> find(List<Criterion> filtros, List<Order> orden, int primero, int maximo);

	public Long count(List<Criterion> filtros);

}