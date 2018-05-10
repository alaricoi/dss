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
@Table(name = "GENEROS")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GENERO", nullable = false, unique = true)
	private int idGenero;

	@Column(name = "DS_GENERO", nullable = false)
	private String dsGenero;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
	private Set<Titulo> titulos = new HashSet<Titulo>(0);

	public int getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getDsGenero() {
		return this.dsGenero;
	}

	public void setDsGenero(String dsGenero) {
		this.dsGenero = dsGenero;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Genero [getIdGenero()=" + getIdGenero() + ", "
				+ (getDsGenero() != null ? "getDsGenero()=" + getDsGenero() + ", " : "") + "hashCode()=" + hashCode()
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsGenero == null) ? 0 : dsGenero.hashCode());
		result = prime * result + idGenero;
		result = prime * result + ((titulos == null) ? 0 : titulos.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		if (dsGenero == null) {
			if (other.dsGenero != null)
				return false;
		} else if (!dsGenero.equals(other.dsGenero))
			return false;
		return (idGenero == other.idGenero);
			
	}

}
