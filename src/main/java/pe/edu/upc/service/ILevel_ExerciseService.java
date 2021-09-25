package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.LevelExercise;

public interface ILevel_ExerciseService {
	public Integer insert(LevelExercise le);
	
	public boolean modificar(LevelExercise le);
	public Optional<LevelExercise> listarId(int idLevel_Exercises);
	
    public void delete(int idNivelEjercicio);
    List<LevelExercise> list();
}
