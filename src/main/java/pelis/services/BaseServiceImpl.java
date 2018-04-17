package pelis.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pelis.dao.AbstractDao;

@Service
public class BaseServiceImpl<PK extends Serializable, E>  implements BaseService<PK, E> {
	
	    private AbstractDao<PK, E> genericDao;
	 
	    public BaseServiceImpl(AbstractDao<PK,E> genericDao) {
	        this.genericDao=genericDao;
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
		public E getByKey(PK key) {
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
}
