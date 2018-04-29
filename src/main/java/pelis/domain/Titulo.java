package pelis.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Isma
 *
 */
@Entity
@Table(name = "TITULOS")
public class Titulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TITULO", nullable = false, unique = true)
	private int idTitulo;

	@Column(name = "DS_TITULO", nullable = false)
	private String dsTitulo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GENERO", nullable = false)
	private Genero genero;

	@Column(name = "TL_REPARTO")
	private String tlReparto;
	@Column(name = "TL_SINOPSIS")
	private String tlSinopsis;

	@Column(name = "DS_DIRECTOR")
	private String dsDirector;

	@Column(name = "NM_ANYO")
	private Integer nmAnyo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "titulo")
	private Set<Opinion> opiniones = new HashSet<Opinion>(0);

	public int getIdTitulo() {
		return idTitulo;
	}

	public void setIdTitulo(int idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getDsTitulo() {
		return dsTitulo;
	}

	public void setDsTitulo(String dsTitulo) {
		this.dsTitulo = dsTitulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTlReparto() {
		return tlReparto;
	}

	public void setTlReparto(String tlReparto) {
		this.tlReparto = tlReparto;
	}

	public String getTlSinopsis() {
		return tlSinopsis;
	}

	public void setTlSinopsis(String tlSnopsis) {
		this.tlSinopsis = tlSnopsis;
	}

	public String getDsDirector() {
		return dsDirector;
	}

	public void setDsDirector(String dsDirector) {
		this.dsDirector = dsDirector;
	}

	public Integer getNmAnyo() {
		return nmAnyo;
	}

	public void setNmAnyo(Integer nmAnyo) {
		this.nmAnyo = nmAnyo;
	}

	/**
	 * @return the opiniones
	 */
	public Set<Opinion> getOpiniones() {
		return opiniones;
	}

	/**
	 * @param opiniones
	 *            the opiniones to set
	 */
	public void setOpiniones(Set<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Titulo [getIdTitulo()=" + getIdTitulo() + ", "
				+ (getDsTitulo() != null ? "getDsTitulo()=" + getDsTitulo() + ", " : "")
				+ (getGenero() != null ? "getGenero()=" + getGenero() + ", " : "")
				+ (getTlReparto() != null ? "getTlReparto()=" + getTlReparto() + ", " : "")
				+ (getTlSinopsis() != null ? "getTlSinopsis()=" + getTlSinopsis() + ", " : "")
				+ (getDsDirector() != null ? "getDsDirector()=" + getDsDirector() + ", " : "")
				+ (getNmAnyo() != null ? "getNmAnyo()=" + getNmAnyo() : "") + "]";
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
		result = prime * result + ((dsDirector == null) ? 0 : dsDirector.hashCode());
		result = prime * result + ((dsTitulo == null) ? 0 : dsTitulo.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + idTitulo;
		result = prime * result + ((nmAnyo == null) ? 0 : nmAnyo.hashCode());
		result = prime * result + ((tlReparto == null) ? 0 : tlReparto.hashCode());
		result = prime * result + ((tlSinopsis == null) ? 0 : tlSinopsis.hashCode());
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
		if (this.getClass() == obj.getClass()) {
			Titulo other = (Titulo) obj;

			return (idTitulo != other.idTitulo);
		} else {
			return false;
		}
	}

}
