package pelis.dao;

import org.springframework.stereotype.Repository;

import pelis.domain.Opinion;

@Repository("opinionDao")
public class OpinionDaoImpl extends AbstractDao<Integer, Opinion> implements OpinionDao {

}
