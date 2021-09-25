package pe.edu.upc.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="editorial")

public class Editorial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEditorial;
	
	@Column(name="Name_Editorial", nullable=false, length=30)
	private String Name_Editorial;
	
	public Editorial(int idEditorial, String name_Editorial) {
		super();
		this.idEditorial = idEditorial;
		Name_Editorial = name_Editorial;
	}

	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getName_Editorial() {
		return Name_Editorial;
	}

	public void setName_Editorial(String name_Editorial) {
		Name_Editorial = name_Editorial;
	}	
	
}
