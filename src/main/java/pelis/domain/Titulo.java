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
@Table(name = "TITULOS")
public class Titulo {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TITULO", nullable=false, unique=true)
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

	
}
