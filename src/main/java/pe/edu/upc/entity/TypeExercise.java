package pe.edu.upc.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeexercise")


public class TypeExercise implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType_Exercises;
	
	@Column(name="typesName", nullable=false, length=30)
	//@Pattern(regexp="[a-zA-Z]", message="El nombre solo puede tener letras")
	private String typesName;

	public TypeExercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeExercise(int idType_Exercises, String typesName) {
		super();
		this.idType_Exercises = idType_Exercises;
		this.typesName = typesName;
	}

	public int getIdType_Exercises() {
		return idType_Exercises;
	}

	public void setIdType_Exercises(int idType_Exercises) {
		this.idType_Exercises = idType_Exercises;
	}

	public String getTypesName() {
		return typesName;
	}

	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}


	


	

	
	
}
