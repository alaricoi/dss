package pelis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENEROS")
public class Genero {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_GENERO", nullable=false, unique=true)
	 private int idGenero;

	@Column(name="DS_GENERO", nullable=false)
	 private String dsGenero;

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getDsGenero() {
		return dsGenero;
	}

	public void setDsGenero(String dsGenero) {
		this.dsGenero = dsGenero;
	}
	
	
}
