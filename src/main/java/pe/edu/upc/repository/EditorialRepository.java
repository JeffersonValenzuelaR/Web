package pe.edu.upc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
	@Query("select count(c.Name_Editorial) from Editorial c where c.Name_Editorial =:name")
    public int buscarNombreEditorial(@Param("name") String nombreEditorial);
}
