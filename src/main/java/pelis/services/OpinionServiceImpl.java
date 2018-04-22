package pelis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pelis.dao.AbstractDao;
import pelis.dao.OpinionDao;
import pelis.domain.Opinion;


@Service("opinionService")
public class OpinionServiceImpl extends BaseServiceImpl<Integer, Opinion> implements OpinionService {
	private OpinionDao dao;

	public OpinionServiceImpl() {

	}

	@Autowired
	public OpinionServiceImpl(@Qualifier("opinionDao") AbstractDao<Integer, Opinion> genericDao) {
		super(genericDao);
		this.setDao((OpinionDao) genericDao);
	}

	public OpinionDao getDao() {
		return dao;
	}

	public void setDao(OpinionDao dao) {
		this.dao = dao;
	}

}
