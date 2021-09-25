package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;
import pe.edu.upc.entity.Forum;

public interface IForumService {
	public Integer insert(Forum fo);
	public Optional<Forum> listarId(int idForums);
    public void delete(int idForums);
    List<Forum> list();
}
