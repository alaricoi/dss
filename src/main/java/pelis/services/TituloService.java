package pelis.services;

import pelis.domain.Titulo;

public interface TituloService extends BaseService<Integer, Titulo> {

	public Titulo find(Integer key);
}
