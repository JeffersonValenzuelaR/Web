package pe.edu.upc.service;
import java.util.List;
import pe.edu.upc.entity.Comments;


public interface ICommentsService {
	public Integer insert(Comments cm);
    List<Comments> list();
}
