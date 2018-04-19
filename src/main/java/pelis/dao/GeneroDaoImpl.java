package pelis.dao;

import org.springframework.stereotype.Repository;

import pelis.domain.Genero;

@Repository("generoDao")
public class GeneroDaoImpl extends AbstractDao<Integer, Genero> implements GeneroDao {

}
