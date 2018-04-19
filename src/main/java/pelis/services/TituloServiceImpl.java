package pelis.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pelis.dao.AbstractDao;
import pelis.dao.TituloDao;
import pelis.domain.Titulo;

@Service("tituloService")

public class TituloServiceImpl extends BaseServiceImpl<Integer, Titulo> implements TituloService {

	private TituloDao dao;

	public TituloServiceImpl() {

	}

	@Autowired
	public TituloServiceImpl(@Qualifier("tituloDao") AbstractDao<Integer, Titulo> genericDao) {
		super(genericDao);
		this.dao =  (TituloDao) genericDao;
	}

	

}