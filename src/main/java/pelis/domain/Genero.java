package pelis.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
	private Set<Titulo> titulos = new HashSet<Titulo>(
			0);

	
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
