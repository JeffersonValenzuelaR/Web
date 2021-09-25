package pe.edu.upc.service;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.DetailsForum;


public interface IDetailsForumService {
	public Integer insert(DetailsForum df);
	public boolean modificar(DetailsForum detailsforum);
	public Optional<DetailsForum> listarId(int idDetails);
    public void delete(int idDetails);
    List<DetailsForum> list();
    public DetailsForum BuscarDetalledeForo(String question);
    public Optional<DetailsForum> listarIdxIdForo(int idForo);
}
