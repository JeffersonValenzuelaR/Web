package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Comments;


@Repository
public interface CommentsRepository  extends JpaRepository<Comments, Integer>{

}
