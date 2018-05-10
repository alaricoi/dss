package pelis.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pelis.dao.AbstractDao;
import pelis.dao.GeneroDao;
import pelis.domain.Genero;

@Service("generoService")
public class GeneroServiceImpl extends BaseServiceImpl<Integer, Genero> implements GeneroService {
	
	@Autowired
	@Qualifier("generoDao") 
	private GeneroDao dao;


	@PostConstruct
	public void init() {
		super.setDao((AbstractDao<Integer, Genero>) dao);
	}
	


	public GeneroDao getGeneroDao() {
		return dao;
	}

	public void setGeneroDao(GeneroDao generoDao) {
		this.dao = generoDao;
	}

}
