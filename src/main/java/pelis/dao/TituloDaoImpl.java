package pelis.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pelis.domain.Titulo;

@Repository("tituloDao")

public class TituloDaoImpl extends AbstractDao<Integer, Titulo> implements TituloDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see pelis.dao.AbstractDao#createEntityCriteria()
	 */
	@Override
	protected Criteria createEntityCriteria() {

		Criteria c = super.createEntityCriteria();
		c.setFetchMode("genero", FetchMode.JOIN);
		return c;
	}

	/**
	 * trae tambien los campos lezy definidos en la creacion del criteria
	 * 
	 * @param key
	 * @return
	 */
	public Titulo find(Integer key) {
		Criteria criteria = createEntityCriteria();

		criteria.add(Restrictions.eq("idTitulo", key));

		return (Titulo) criteria.uniqueResult();

	}
}
