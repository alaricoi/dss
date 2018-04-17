package pelis.services;

import java.util.List;

public interface BaseService <PK, E> {
	
    public void saveOrUpdate(E entity);
    public List<E> getAll();
    public E getByKey(PK key);
    public Integer save(E entity);
    public void update(E entity);
    public void delete(E entity);
}