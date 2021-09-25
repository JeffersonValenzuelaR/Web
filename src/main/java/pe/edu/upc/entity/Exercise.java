package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")

public class Exercise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExercise;

	@ManyToOne
    @JoinColumn(name = "idLevelExercise")
    private LevelExercise levelexercise;
	
	@ManyToOne
    @JoinColumn(name = "idTypeExercise")
    private TypeExercise typeexercise;

	public int getIdExercise() {
		return idExercise;
	}

	public void setIdExercise(int idExercise) {
		this.idExercise = idExercise;
	}

	public LevelExercise getLevelexercise() {
		return levelexercise;
	}

	public void setLevelexercise(LevelExercise levelexercise) {
		this.levelexercise = levelexercise;
	}

	public TypeExercise getTypeexercise() {
		return typeexercise;
	}

	public void setTypeexercise(TypeExercise typeexercise) {
		this.typeexercise = typeexercise;
	}

	
		

}
