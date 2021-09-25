package pe.edu.upc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Forum;


@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer>{
	@Query("select count(c.Topic) from Forum c where c.Topic =:topic")
    public int buscarNombreForum(@Param("topic") String Topic);
}
