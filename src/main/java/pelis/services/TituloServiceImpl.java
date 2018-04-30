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
	@Autowired
	@Qualifier("tituloDao")
	private TituloDao dao;

	public TituloServiceImpl() {
		
	}
	@Override
	public AbstractDao<Integer, Titulo> getDao() {
		return (AbstractDao<Integer, Titulo>) dao;
	}

	public void setDao(TituloDao dao) {
		this.dao = dao;
	}

	/**
	 * Metodo que devuelve un objeto de dominio a partir de una clave
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Titulo find(Integer key) {

		return dao.find(key);
	}

}