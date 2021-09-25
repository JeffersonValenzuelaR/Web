package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.TypeUser;


@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Integer>{

}
