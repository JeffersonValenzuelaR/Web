package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Exercise;

public interface IExercise_Service {
	public Integer insert(Exercise e);
	public boolean modificar(Exercise e);
	public Optional<Exercise> listarId(int idExercise);
    public void delete(int idExercise);
    List<Exercise> list();
}
