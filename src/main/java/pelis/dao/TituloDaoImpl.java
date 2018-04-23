package pelis.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Repository;

import pelis.domain.Titulo;
@Repository("tituloDao")
public class TituloDaoImpl extends AbstractDao<Integer, Titulo> implements TituloDao {

	/* (non-Javadoc)
	 * @see pelis.dao.AbstractDao#createEntityCriteria()
	 */
	@Override
	protected Criteria createEntityCriteria() {
	
		Criteria c =  super.createEntityCriteria();
		c.setFetchMode("genero", FetchMode.JOIN);
		return c;
	}
   
	
}
