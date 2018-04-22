package pelis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPINIONES")
public class Opinion {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_OPINION", nullable=false, unique=true)
	 private int idOpinion;

	@Column(name="TL_OPINION", nullable=false)
	 private String tlOpinion;
	

	@Column(name="NM_OPINION", nullable=false)
	 private Integer nmOpinion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TITULO", nullable = false)
	private Titulo titulo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_user_id", nullable = false)
	private User user;


	/**
	 * @return the idOpinion
	 */
	public int getIdOpinion() {
		return idOpinion;
	}


	/**
	 * @param idOpinion the idOpinion to set
	 */
	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}


	/**
	 * @return the tlOpinion
	 */
	public String getTlOpinion() {
		return tlOpinion;
	}


	/**
	 * @param tlOpinion the tlOpinion to set
	 */
	public void setTlOpinion(String tlOpinion) {
		this.tlOpinion = tlOpinion;
	}


	/**
	 * @return the nmOpinion
	 */
	public Integer getNmOpinion() {
		return nmOpinion;
	}


	/**
	 * @param nmOpinion the nmOpinion to set
	 */
	public void setNmOpinion(Integer nmOpinion) {
		this.nmOpinion = nmOpinion;
	}


	/**
	 * @return the titulo
	 */
	public Titulo getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Opinion [getIdOpinion()=" + getIdOpinion() + ", "
				+ (getTlOpinion() != null ? "getTlOpinion()=" + getTlOpinion() + ", " : "")
				+ (getNmOpinion() != null ? "getNmOpinion()=" + getNmOpinion() + ", " : "")
				+ (getTitulo() != null ? "getTitulo()=" + getTitulo() + ", " : "")
				+ (getUser() != null ? "getUser()=" + getUser() : "") + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOpinion;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Opinion))
			return false;
		Opinion other = (Opinion) obj;
		if (idOpinion != other.idOpinion)
			return false;
		return true;
	}
	
	
	
}
