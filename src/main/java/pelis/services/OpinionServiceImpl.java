package pelis.services;

/**
 * @author Isma
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pelis.dao.AbstractDao;
import pelis.dao.OpinionDao;
import pelis.domain.Opinion;

@Service("opinionService")
public class OpinionServiceImpl extends BaseServiceImpl<Integer, Opinion> implements OpinionService {
	
	@Autowired
	@Qualifier("opinionDao")
	private OpinionDao dao;

	public OpinionServiceImpl() {

	}

	
	@Override
	public AbstractDao<Integer, Opinion> getDao() {
		return (AbstractDao<Integer, Opinion>) dao;
	}

	public void setDao(OpinionDao dao) {
		this.dao = dao;
	}

}
