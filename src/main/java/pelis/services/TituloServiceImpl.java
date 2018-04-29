package pelis.services;

/**
 * @author Isma
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pelis.dao.AbstractDao;
import pelis.dao.TituloDao;
import pelis.domain.Titulo;

@Service("tituloService")

public class TituloServiceImpl extends BaseServiceImpl<Integer, Titulo> implements TituloService {

	private TituloDao dao;

	@Autowired
	public TituloServiceImpl(@Qualifier("tituloDao") AbstractDao<Integer, Titulo> genericDao) {
		super(genericDao);
		this.setDao((TituloDao) genericDao);
	}

	public TituloDao getDao() {
		return dao;
	}

	public void setDao(TituloDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Titulo find(Integer key) {

		return getDao().find(key);
	}

}