package pelis.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao<P extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(P key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    
    public Integer save(T entity){
    	return  (Integer) getSession().save(entity);
	}
	
	public void update(T entity){
		  getSession().update(entity);
	}
	
	public void saveOrUpdate(T entity){
		  getSession().saveOrUpdate(entity);
	}

    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    @SuppressWarnings("unchecked")
	public List<T> getAll() {
        return createEntityCriteria().list();
    }
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
   
    
    
    @SuppressWarnings("unchecked")
	public List<T> find (List<Criterion> filtros, List<Order> orden){
    	Criteria criteria = createEntityCriteria();
    	
    	for (Criterion c : filtros) {
    		criteria.add(c);
    	}
    	
    	for (Order o : orden) {
    		criteria.addOrder(o);
    	}
		return (List<T>) criteria.list();
    	
    }
    
    @SuppressWarnings("unchecked")
	public List<T> find (List<Criterion> filtros, List<Order> orden, int primero, int cuantos){
    	Criteria criteria = createEntityCriteria();
    	
    	for (Criterion c : filtros) {
    		criteria.add(c);
    	}
    	for (Order o : orden) {
    		criteria.addOrder(o);
    	}
    	criteria.setFirstResult(primero);
    	criteria.setMaxResults(cuantos);
    	
		return (List<T>) criteria.list();
    	
    }
     public Long count(List<Criterion> filtros) {
    	 Criteria criteria = createEntityCriteria();
     	
     	for (Criterion c : filtros) {
     		criteria.add(c);
     	}
     	return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
     }
}