package pelis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pelis.dao.AbstractDao;
import pelis.dao.GeneroDao;
import pelis.domain.Genero;

@Service("generoService")
public class GeneroServiceImpl extends BaseServiceImpl<Integer, Genero> implements GeneroService {
	private GeneroDao generoDao;

	public GeneroServiceImpl() {

	}

	@Autowired
	public GeneroServiceImpl(@Qualifier("generoDao") AbstractDao<Integer, Genero> genericDao) {
		super(genericDao);
		this.setGeneroDao((GeneroDao) genericDao);
	}

	public GeneroDao getGeneroDao() {
		return generoDao;
	}

	public void setGeneroDao(GeneroDao generoDao) {
		this.generoDao = generoDao;
	}

}
