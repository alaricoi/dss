package pelis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TITULOS")
public class Titulo {
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="ID_TITULO", unique=true, nullable=false)
	 private int id;
	 
}
