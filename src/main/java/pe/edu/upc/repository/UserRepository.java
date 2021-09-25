package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	@Query("from Users a where upper(a.username)=upper(:parametro)")
    public Users findByUserAccount(@Param("parametro")String users);
	
}
