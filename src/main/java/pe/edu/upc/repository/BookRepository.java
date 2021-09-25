package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	//@Query("select count(c.Name_Editorial) from Editorial c where c.Name_Editorial =:name")
    //public int buscarNombreEditorial(@Param("name") String nombreEditorial);
	
	@Query("from Book c where  c.name_Book like %:name%")
	public List<Book> buscarlibro(@Param("name") String name_Book);
}

