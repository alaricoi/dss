package pelis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pelis.dao.AbstractDao;
import pelis.dao.GeneroDao;
import pelis.domain.Genero;
import pelis.services.BaseServiceImpl;
import pelis.services.GeneroService;

@Service("generoService")
public class GeneroServiceImpl  extends BaseServiceImpl<Integer, Genero> 
         implements GeneroService{
	 private GeneroDao generoDao;
	 
	    public GeneroServiceImpl(){
	 
	    }
	    @Autowired
	    public GeneroServiceImpl(
	            @Qualifier("generoDao") AbstractDao<Integer, Genero> genericDao) {
	        super(genericDao);
	        this.generoDao = (GeneroDao) genericDao;
	    }
	 
}
