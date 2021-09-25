package pe.edu.upc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.LevelExercise;

@Repository
public interface Level_ExerciseRepository extends JpaRepository<LevelExercise, Integer>{
	@Query("select count(c.levelsName) from LevelExercise c where c.levelsName =:name")
    public int buscarNombreNivelEjercicio(@Param("name") String nombreNivelEjercicio);
}
