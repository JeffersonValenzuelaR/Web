package pe.edu.upc.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="levelexercise")

public class LevelExercise implements Serializable  {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLevel_Exercises;
	
	@Column(name="levelsName", nullable=false, length=30)
	//@Pattern(regexp="(\\d{2}[A-Z])", message="El nombre solo puede tener una letra y un numero")
	private String levelsName;

	public LevelExercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdLevel_Exercises() {
		return idLevel_Exercises;
	}

	public void setIdLevel_Exercises(int idLevel_Exercises) {
		this.idLevel_Exercises = idLevel_Exercises;
	}

	public String getLevelsName() {
		return levelsName;
	}

	public void setLevelsName(String levelsName) {
		this.levelsName = levelsName;
	}

	
	
}
