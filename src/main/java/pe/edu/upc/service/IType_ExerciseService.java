package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.TypeExercise;

public interface IType_ExerciseService {
	public Integer insert(TypeExercise te);
    public void delete(int idTipoEjercicio);
    List<TypeExercise> list();
}
