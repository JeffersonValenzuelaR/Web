package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.TypeExercise;

@Repository
public interface Type_ExerciseRepository extends JpaRepository<TypeExercise, Integer>{
	@Query("select count(c.typesName) from TypeExercise c where c.typesName =:name")
    public int buscarNombreTipoEjercicio(@Param("name") String nombreTipoEjercicio);
}
