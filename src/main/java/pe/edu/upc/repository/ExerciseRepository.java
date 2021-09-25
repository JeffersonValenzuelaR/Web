package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{
	//@Query("select count(c.Name_Editorial) from Editorial c where c.Name_Editorial =:name")
    //public int buscarNombreEditorial(@Param("name") String nombreEditorial);
}

